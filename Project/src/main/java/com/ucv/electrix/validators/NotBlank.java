package com.ucv.electrix.validators;

import com.ucv.electrix.validators.implementations.NotBlankValidatorImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotBlankValidatorImpl.class)
@Documented
public @interface NotBlank {
    String message() default "{categoryDTO.default}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
