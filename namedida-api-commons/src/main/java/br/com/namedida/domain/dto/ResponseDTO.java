package br.com.namedida.domain.dto;


import br.com.namedida.core.business.BusinessError;
import br.com.namedida.core.business.Result;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ResponseDTO {
    private List<String> errors = new ArrayList<>();
    private Boolean success;
    private Object content;



    /**
     *
     * @param result
     */
    public void businessErrorResponse(Result result) {
        this.success = false;
        this.errors = result.getErrors()
                .stream()
                .map(BusinessError::getMessage)
                .collect(Collectors.toList());
    }

    /**
     *
     * @param result
     */
    public void successResponse(Result result) {
        this.success = true;
        this.content = result.getData();
    }

    /**
     *
     * @param message
     */
    public void errorResponse(String message) {
        this.success = false;
        if(this.errors == null) {
            this.errors = new ArrayList<String>();
        }
        this.errors.add(message);
    }
}
