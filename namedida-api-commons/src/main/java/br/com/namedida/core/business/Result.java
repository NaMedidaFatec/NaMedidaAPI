package br.com.namedida.core.business;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Result {
    private List<BusinessError> errors;
    private Object data;

    public Result() {
        errors = new ArrayList<>();
    }

    public Boolean hasErrors() {
        return !this.errors.isEmpty();
    }

    public void addError(BusinessError error) {
        this.errors.add(error);
    }

    public void appendErrors(Result partial) {
        this.errors.addAll(partial.getErrors());
    }
}
