package com.ucv.electrix.validators.implementations;

import com.ucv.electrix.models.Category;
import com.ucv.electrix.repositories.CategoryRepository;
import com.ucv.electrix.validators.annotations.CategoryMustExists;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class MustExistsValidatorImpl implements ConstraintValidator<CategoryMustExists, String> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Optional<Category> optional = categoryRepository.findByName(value);
        if(optional.isPresent()){
            return true;
        }
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate("{categoryDTO.doesntExist}").addConstraintViolation();
        return false;
    }
}
