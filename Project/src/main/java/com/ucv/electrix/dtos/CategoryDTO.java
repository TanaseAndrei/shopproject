package com.ucv.electrix.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class CategoryDTO {

    @NotNull
    @NotBlank
    @Min(value = 0, message = "The category's name should not be empty")
    private String categoryName;

    private CategoryDTO parentCategory;

}
