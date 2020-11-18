package com.ucv.electrix.services;

import com.ucv.electrix.dtos.CategoryDTO;
import com.ucv.electrix.models.Category;

import java.util.List;

public interface CategoryService {
    void add(CategoryDTO categoryDTO);
    List<CategoryDTO> getParentCategories();
    void delete(CategoryDTO categoryDTO);
    void update(String name, CategoryDTO categoryDTO);
    CategoryDTO get(String name);
    List<CategoryDTO> getAll();
}
