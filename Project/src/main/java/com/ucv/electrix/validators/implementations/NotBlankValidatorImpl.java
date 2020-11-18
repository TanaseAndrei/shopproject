package com.ucv.electrix.validators.implementations;

import com.ucv.electrix.validators.NotBlank;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotBlankValidatorImpl implements ConstraintValidator<NotBlank, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(!value.isBlank()){
            return true;
        }
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate("{categoryDTO.notBlank}").addConstraintViolation();
        return false;
    }
}
