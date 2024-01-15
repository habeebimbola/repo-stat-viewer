package com.repoviewer.domain.validation;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

public class ApiRequestValidator {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> errors = new ArrayList<>();
    private final String errorMessage;


    public ApiRequestValidator(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void addValidationError(String errorMessage)
    {
        errors.add(errorMessage);
    }
    public String getErrorMessage() {
        return errorMessage;
    }

    public List<String> getErrors() {
        return errors;
    }
}
