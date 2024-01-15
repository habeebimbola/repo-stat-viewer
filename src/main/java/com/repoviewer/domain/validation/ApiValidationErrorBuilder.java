package com.repoviewer.domain.validation;

import org.springframework.validation.Errors;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class ApiValidationErrorBuilder {

    private final  static Pattern githubMetadataValidator = Pattern.compile("^(\\w+-?\\w+)$");
    public static ApiRequestValidator fromBindingErrors(Errors errors)
    {
        ApiRequestValidator apiRequestValidator = new ApiRequestValidator("There are "+errors.getErrorCount()+" total errors.");

        errors.getAllErrors().forEach((objectError)-> apiRequestValidator.addValidationError(objectError.getDefaultMessage()));

        return  apiRequestValidator;
    }

    public static ApiRequestValidator fromStringErrors(List<String> errors)
    {
        ApiRequestValidator apiRequestValidator = new ApiRequestValidator(String.format("%s %d %s", "There are ",errors.size(), " errors. Please Modify the request"));
        errors.forEach(apiRequestValidator::addValidationError);
        return apiRequestValidator;
    }

    public static boolean wrongInputParameters(String owner, String repo)
    {
        if(!githubMetadataValidator.matcher(owner).matches() || !githubMetadataValidator.matcher(repo).matches())
        {
            return true;
        }
        return false;
    }
}
