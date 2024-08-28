package com.validation.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NBACodeConstraintValidator implements ConstraintValidator<NBACode, String> {

    private String nbaPrefix;

    @Override
    public void initialize(NBACode nbaCode) {
        nbaPrefix = nbaCode.value();
    }

    @Override
    public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {
        if (code != null) {
            return code.startsWith(nbaPrefix);
        } else {
            return true;
        }

    }
}
