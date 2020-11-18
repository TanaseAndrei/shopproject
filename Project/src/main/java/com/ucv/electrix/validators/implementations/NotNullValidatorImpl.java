package com.ucv.electrix.validators.implementations;

import com.ucv.electrix.validators.NotNull;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotNullValidatorImpl implements ConstraintValidator<NotNull, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value != null){
            return true;
        }
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate("{categoryDTO.notNull}").addConstraintViolation();
        return false;
    }
}
