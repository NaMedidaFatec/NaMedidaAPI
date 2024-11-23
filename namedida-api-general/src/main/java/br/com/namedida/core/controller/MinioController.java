package br.com.namedida.core.controller;
import br.com.namedida.core.service.MinioService;
import br.com.namedida.domain.form.MinioForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/minio")
@RequiredArgsConstructor
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        methods = {RequestMethod.HEAD, RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
)
public class MinioController {
    private final MinioService service;

    @PostMapping("/upload")
    public void upload(@RequestPart("documento") String metadata,  @RequestPart(value = "file", required=false) MultipartFile file) {
        service.uploadFile(metadata, file);
    }

    @RequestMapping(value="/download/", method = RequestMethod.POST)
    public ResponseEntity<byte[]> download(@RequestBody MinioForm form) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment; filename=" +  form.getObjectName());
            return ResponseEntity.ok().headers(headers)
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(service.downloadFile(form));
        } catch (Exception e) {
            throw e;
        }
    }
}