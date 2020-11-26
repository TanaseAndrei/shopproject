package com.ucv.electrix.dtos;

import com.ucv.electrix.validators.annotations.NotBlank;
import com.ucv.electrix.validators.annotations.NotNull;
import com.ucv.electrix.validators.annotations.CategoryMustExists;
import com.ucv.electrix.validators.annotations.CategoryMustNotExists;
import com.ucv.electrix.validators.groups.CreateCategory;
import com.ucv.electrix.validators.groups.CreateSubcategory;
import com.ucv.electrix.validators.groups.DeleteCategory;
import com.ucv.electrix.validators.groups.UpdateCategory;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Setter
@Getter
public class CategoryDTO {

    @Nullable
    private Integer id;

    @NotBlank(groups = {CreateCategory.class, CreateSubcategory.class, DeleteCategory.class, UpdateCategory.class})
    @NotNull(groups = {CreateCategory.class, CreateSubcategory.class, DeleteCategory.class, UpdateCategory.class})
    @CategoryMustNotExists(groups = {CreateCategory.class, CreateSubcategory.class, UpdateCategory.class})
    @CategoryMustExists(groups = {DeleteCategory.class})
    private String categoryName;

    @NotBlank(groups = {CreateSubcategory.class})
    @NotNull(groups = {CreateSubcategory.class})
    @CategoryMustExists(groups = {CreateSubcategory.class})
    private String parentCategoryName;

}
