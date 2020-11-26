package com.ucv.electrix.services;

import com.ucv.electrix.dtos.CategoryDTO;
import com.ucv.electrix.exceptions.services.EntityNotFoundServiceException;

import java.util.List;

public interface CategoryService {
    void add(CategoryDTO categoryDTO);
    List<CategoryDTO> getParentCategories();
    void delete(CategoryDTO categoryDTO);
    void update(CategoryDTO categoryDTO);
    CategoryDTO get(String name);
    CategoryDTO get(Integer id) throws EntityNotFoundServiceException;
    List<CategoryDTO> getAllSubcategories();
}
