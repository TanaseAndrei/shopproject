package com.ucv.electrix.services.implementations;

import com.ucv.electrix.dtos.CategoryDTO;
import com.ucv.electrix.exceptions.EntityNotFoundServiceException;
import com.ucv.electrix.mappers.CategoryMapper;
import com.ucv.electrix.models.Category;
import com.ucv.electrix.repositories.CategoryRepository;
import com.ucv.electrix.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void add(CategoryDTO categoryDTO) {
        Category category = CategoryMapper.categoryDTOToCategoryMapper(categoryDTO);
        categoryRepository.save(category);
    }

    @Override
    public void addSubcategory(CategoryDTO categoryDTO) {
        Category category = CategoryMapper.categoryDTOToCategoryMapper(categoryDTO);
        categoryRepository.save(category);
    }

    @Override
    public List<CategoryDTO> getParentCategories() {
        List<CategoryDTO> listOfDTOCategories = CategoryMapper.listOfCategoriesToListOfCategoriesDTOMapper(categoryRepository.findParentCategories());
        return listOfDTOCategories;
    }

    @Override
    public void delete(Integer id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundServiceException("The service did not find the searched category to delete!"));
        categoryRepository.delete(category);
    }

    @Override
    public void update(Integer id, CategoryDTO categoryDTO) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundServiceException("The service did not find the searched category to update!"));
        category.setParentCategory(CategoryMapper.categoryDTOToCategoryMapper(categoryDTO.getParentCategory()));
        category.setCategoryName(categoryDTO.getCategoryName());
        categoryRepository.save(category);
    }

    @Override
    public CategoryDTO get(Integer id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundServiceException("The service did not find the searched category!"));
        return CategoryMapper.categoryToCategoryDTOMapper(category);
    }

    @Override
    public List<CategoryDTO> getAll() {
        List<Category> listOfCategories = categoryRepository.findAll();
        return CategoryMapper.listOfCategoriesToListOfCategoriesDTOMapper(listOfCategories);
    }
}
