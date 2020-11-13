package com.ucv.electrix.dtos;

import com.ucv.electrix.models.Category;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class ProductDTO {

    @NotNull
    @NotBlank
    @Min(value = 1, message = "You must enter a name")
    private String name;

    @NotNull
    @NotBlank
    @Min(value = 1, message = "You must enter a price")
    private Float price;

    @NotNull
    @NotBlank
    @Min(value = 1, message = "You must enter a stock")
    private Integer stock;

    @NotNull

    @NotBlank
    @Min(value = 1, message = "You must enter a brand")
    private String brand;

    @NotNull
    @NotBlank
    @Min(value = 1, message = "You must enter some details")
    private String details;

    @NotNull
    @Min(value = 1, message = "You must enter a category")
    private Category category;

}
