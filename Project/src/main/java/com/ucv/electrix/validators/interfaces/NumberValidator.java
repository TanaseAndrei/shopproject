package com.ucv.electrix.validators.interfaces;

import com.ucv.electrix.validators.annotations.ValidNumber;

import javax.validation.ConstraintValidator;

public interface NumberValidator<T extends Number> extends ConstraintValidator<ValidNumber, T> {
}
