package com.ucv.electrix.validators.implementations;

import com.ucv.electrix.models.Product;
import com.ucv.electrix.repositories.ProductRepository;
import com.ucv.electrix.validators.annotations.ProductMustNotExists;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class ProductMustNotExistsValidatorImpl implements ConstraintValidator<ProductMustNotExists, String> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Optional<Product> optionalProduct = productRepository.findByName(value);
        if(!optionalProduct.isPresent()){
            return true;
        }
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate("{productDTO.alreadyExists}").addConstraintViolation();
        return false;
    }
}
