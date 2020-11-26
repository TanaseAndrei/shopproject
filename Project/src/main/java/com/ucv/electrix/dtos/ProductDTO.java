package com.ucv.electrix.dtos;

import com.ucv.electrix.validators.annotations.CategoryMustExists;
import com.ucv.electrix.validators.annotations.ProductMustNotExists;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class ProductDTO {

    @NotNull
    @NotBlank
    @ProductMustNotExists
    private String name;

    @NotNull
    @Min(value = 1, message = "You must enter a price")
    private Float price;

    @NotNull
    @Min(value = 1, message = "You must enter a stock")
    private Integer stock;

    @NotNull
    @NotBlank
    private String brand;

    @NotNull
    @NotBlank
    private String details;

    @NotNull
    @NotBlank
    @CategoryMustExists
    private String category;

    private MultipartFile multipartFile;

}
