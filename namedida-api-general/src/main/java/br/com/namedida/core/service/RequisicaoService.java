package br.com.namedida.core.service;

import br.com.namedida.core.business.IValidation;
import br.com.namedida.core.business.Result;
import br.com.namedida.core.persistence.GenericRepository;
import br.com.namedida.core.service.security.bean.StakeholdersBean;
import br.com.namedida.core.validator.DepartamentoValidator;
import br.com.namedida.core.validator.RequisicaoValidator;
import br.com.namedida.core.validator.UnidadeEnsinoValidator;
import br.com.namedida.domain.*;
import br.com.namedida.domain.form.RequisicaoForm;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class RequisicaoService extends GenericService<Requisicao> {
    private final StakeholdersBean stakeholdersBean;

    private final NotificacaoService notificacaoService;

    private final RequisicaoItemService requisicaoItemService;


    @Autowired
    public RequisicaoService(
            GenericRepository<Requisicao> repository,
            List<IValidation<Requisicao>> saveValidations,
            List<IValidation<Requisicao>> updateValidation, StakeholdersBean stakeholdersBean, NotificacaoService notificacaoService, UsuarioDepartamentoService departamentoService, RequisicaoItemService requisicaoItemService)
    {
        super();
        this.notificacaoService = notificacaoService;
        this.requisicaoItemService = requisicaoItemService;
        this.repository = repository;
        this.saveValidations = saveValidations;
        this.updateValidations = updateValidation;
        this.stakeholdersBean = stakeholdersBean;
    }

    public Result save(RequisicaoForm form) throws Exception {
        Usuario solicitante = stakeholdersBean.getUsuarioDepartamento() != null ? stakeholdersBean.getUsuarioDepartamento() : stakeholdersBean.getUsuarioUnidadeEnsino();
        Requisicao requisicao = Requisicao.requisicaoBuilder()
                .id(form.getId())
                .observacoes(form.getObservacoes())
                .data(LocalDate.now())
                .finalizada(form.isFinalizada())
                .departamento(DepartamentoValidator.validate(form.getDepartamento()))
                .unidadeEnsino(UnidadeEnsinoValidator.validate(form.getUnidadeEnsino()))
                .solicitante(solicitante)
                .build();

        this.executeRules(this.saveValidations, requisicao);
        if (!this.result.hasErrors()) {
            requisicao = this.repository.save(requisicao);
            this.result.setData(requisicao);
        }

        if (requisicao != null) {
            notificacaoService.sendNotificacaoRequisicao(requisicao);

        }
        return this.result;
    }


    public ResponseEntity<Resource> gerarRelatorio(Long requisicaoId) throws IOException, Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Requisicao requisicao = RequisicaoValidator.validate(requisicaoId);
        List<RequisicaoItem> itens = (List<RequisicaoItem>) requisicaoItemService.getItens(requisicaoId).getData();

        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("Itens do Pedido");

        Row headerRowPedido = sheet.createRow(0);

        Cell headerRequisicaoCell = headerRowPedido.createCell(0);
        headerRequisicaoCell.setCellValue("Pedido");

        Cell headerDataCell = headerRowPedido.createCell(1);
        headerDataCell.setCellValue("Data");

        Cell headerSolicitanteCell = headerRowPedido.createCell(2);
        headerSolicitanteCell.setCellValue("Solicitante");

        Cell headerObservacoesCell = headerRowPedido.createCell(3);
        headerObservacoesCell.setCellValue("Observações");

        Row rowPedido = sheet.createRow(1);

        Cell requisicaoCell = rowPedido.createCell(0);
        requisicaoCell.setCellValue(requisicaoId);

        Cell dataCell = rowPedido.createCell(1);

        dataCell.setCellValue(requisicao.getData().format(formatter));

        Cell solicitanteCell = rowPedido.createCell(2);
        solicitanteCell.setCellValue(requisicao.getSolicitante().getNome());

        Cell observacoesCell = rowPedido.createCell(3);
        observacoesCell.setCellValue(requisicao.getObservacoes());

        sheet.createRow(2);

        Row headerRowPedidoItem = sheet.createRow(3);

        Cell headerRequisicaoItemCell = headerRowPedidoItem.createCell(0);
        headerRequisicaoItemCell.setCellValue("Código");

        Cell headerProdutoCell = headerRowPedidoItem.createCell(1);
        headerProdutoCell.setCellValue("Produto");

        Cell headerQuantidadeCell = headerRowPedidoItem.createCell(2);
        headerQuantidadeCell.setCellValue("Quantidade");

        Cell headerQuantidadeConsumidaCell = headerRowPedidoItem.createCell(3);
        headerQuantidadeConsumidaCell.setCellValue("Quantidade Consumida");

        int rowIndex = 4;
        for (RequisicaoItem item : itens) {
            Row dataRow = sheet.createRow(rowIndex++);
            dataRow.createCell(0).setCellValue(item.getId());
            dataRow.createCell(1).setCellValue(item.getProduto().getNome());
            dataRow.createCell(2).setCellValue(item.getQuantidade());
            dataRow.createCell(5).setCellValue("");
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();

        InputStreamResource inputStreamResource = new InputStreamResource(new ByteArrayInputStream(outputStream.toByteArray()));

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + requisicaoId + ".xls");
        headers.add(HttpHeaders.CACHE_CONTROL, "no-cache, no-store, must-revalidate");
        headers.add(HttpHeaders.PRAGMA, "no-cache");
        headers.add(HttpHeaders.EXPIRES, "0");
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentType(MediaType.parseMediaType("application/vnd.ms-excel"));

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .headers(headers)
                .body(inputStreamResource);
    }
}