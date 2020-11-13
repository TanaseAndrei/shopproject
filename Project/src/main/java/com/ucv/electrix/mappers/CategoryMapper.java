package com.ucv.electrix.mappers;

import com.ucv.electrix.dtos.CategoryDTO;
import com.ucv.electrix.models.Category;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryMapper {

    public static Category categoryDTOToCategoryMapper(CategoryDTO categoryDTO){
        Category category = new Category();
        category.setCategoryName(categoryDTO.getCategoryName());
        if(categoryDTO.getParentCategory() == null){
            category.setParentCategory(null);
        } else {
            category.setParentCategory(categoryDTOToCategoryMapper(categoryDTO.getParentCategory()));
        }
        return category;
    }

    public static CategoryDTO categoryToCategoryDTOMapper(Category category){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryName(category.getCategoryName());
        categoryDTO.setParentCategory(categoryToCategoryDTOMapper(category));
        return categoryDTO;
    }

    public static List<CategoryDTO> listOfCategoriesToListOfCategoriesDTOMapper(List<Category> listOfCategories){
        List<CategoryDTO> listOfCategoriesDTO = listOfCategories
                .stream()
                .map(category ->{
                    CategoryDTO categoryDTO = new CategoryDTO();
                    categoryDTO.setParentCategory(categoryToCategoryDTOMapper(category));
                    categoryDTO.setCategoryName(category.getCategoryName());
                    return categoryDTO;
                })
                .collect(Collectors.toList());
        return listOfCategoriesDTO;
    }
}
