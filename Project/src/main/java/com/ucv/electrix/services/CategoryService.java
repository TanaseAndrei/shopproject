package com.ucv.electrix.services;

import com.ucv.electrix.dtos.CategoryDTO;

import java.util.List;

public interface CategoryService {
    void add(CategoryDTO categoryDTO);
    void addSubcategory(CategoryDTO categoryDTO);
    List<CategoryDTO> getParentCategories();
    void delete(Integer id);
    void update(Integer id, CategoryDTO categoryDTO);
    CategoryDTO get(Integer id);
    List<CategoryDTO> getAll();
}
