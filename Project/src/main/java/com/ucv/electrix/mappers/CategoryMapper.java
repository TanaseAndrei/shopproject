package com.ucv.electrix.mappers;

import com.ucv.electrix.dtos.CategoryDTO;
import com.ucv.electrix.models.Category;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryMapper {

    public static Category categoryDTOToCategoryMapper(CategoryDTO categoryDTO){
        Category category = new Category();
        category.setCategoryName(categoryDTO.getCategoryName());
        category.setParentCategory(null);
        return category;
    }

    public static CategoryDTO categoryToCategoryDTOMapper(Category category){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setCategoryName(category.getCategoryName());
        if(category.getParentCategory() == null){
            categoryDTO.setParentCategoryName(null);
        } else {
            categoryDTO.setParentCategoryName(category.getParentCategory().getCategoryName());
        }
        return categoryDTO;
    }

    public static List<CategoryDTO> listOfCategoriesToListOfCategoriesDTOMapper(List<Category> listOfCategories){
        return listOfCategories
                .stream()
                .map(category ->{
                    CategoryDTO categoryDTO = categoryToCategoryDTOMapper(category);
                    return categoryDTO;
                })
                .collect(Collectors.toList());
    }
}
