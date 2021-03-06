package com.ucv.electrix.validators.annotations;

import com.ucv.electrix.validators.implementations.MustNotExistsValidatorImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MustNotExistsValidatorImpl.class)
@Documented
public @interface CategoryMustNotExists {
    String message() default "{categoryDTO.default}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
