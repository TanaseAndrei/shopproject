package com.ucv.electrix.validators.annotations;

import com.ucv.electrix.validators.implementations.ProductMustNotExistsValidatorImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ProductMustNotExistsValidatorImpl.class)
@Documented
public @interface ProductMustNotExists {
    String message() default "{productDTO.default}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
