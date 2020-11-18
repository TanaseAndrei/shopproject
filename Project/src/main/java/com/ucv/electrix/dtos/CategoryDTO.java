package com.ucv.electrix.dtos;

import com.ucv.electrix.validators.NotBlank;
import com.ucv.electrix.validators.NotNull;
import com.ucv.electrix.validators.MustExists;
import com.ucv.electrix.validators.MustNotExists;
import com.ucv.electrix.validators.validated.CreateCategory;
import com.ucv.electrix.validators.validated.CreateSubcategory;
import com.ucv.electrix.validators.validated.DeleteCategory;
import com.ucv.electrix.validators.validated.UpdateCategory;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoryDTO {

    @NotBlank(groups = {CreateCategory.class, CreateSubcategory.class, DeleteCategory.class})
    @NotNull(groups = {CreateCategory.class, CreateSubcategory.class, DeleteCategory.class})
    @MustNotExists(groups = {CreateCategory.class, CreateSubcategory.class})
    @MustExists(groups = {DeleteCategory.class, UpdateCategory.class})
    private String categoryName;

    @NotBlank(groups = {CreateSubcategory.class})
    @NotNull(groups = {CreateSubcategory.class})
    @MustExists(groups = {CreateSubcategory.class})
    private String parentCategoryName;

}
