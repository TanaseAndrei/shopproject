package com.ucv.electrix.services.implementations;

import com.ucv.electrix.dtos.CategoryDTO;
import com.ucv.electrix.exceptions.services.EntityNotFoundServiceException;
import com.ucv.electrix.mappers.CategoryMapper;
import com.ucv.electrix.models.Category;
import com.ucv.electrix.repositories.CategoryRepository;
import com.ucv.electrix.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void add(CategoryDTO categoryDTO) {
        Category category = CategoryMapper.categoryDTOToCategoryMapper(categoryDTO);
        Category parentCategory;
        if (categoryDTO.getParentCategoryName() != null) {
            parentCategory = categoryRepository.findByName(categoryDTO.getParentCategoryName()).get();
            category.setParentCategory(parentCategory);
        }
        categoryRepository.save(category);
    }

    @Override
    public List<CategoryDTO> getParentCategories() {
        List<Category> listOfCategories = categoryRepository.findParentCategories();
        return CategoryMapper.listOfCategoriesToListOfCategoriesDTOMapper(listOfCategories);
    }

    @Override
    public void delete(CategoryDTO categoryDTO) {
        Category category = categoryRepository.findByName(categoryDTO.getCategoryName()).get();
        if (category.getParentCategory() == null) {
            List<Category> subcategoriesOfParentCategory = categoryRepository.findAllByParentCategory(categoryDTO.getCategoryName());
            subcategoriesOfParentCategory
                    .forEach(categoryRepository::delete);
        }
        categoryRepository.delete(category);
    }

    @Override
    public void update(CategoryDTO categoryDTO) {
        Category category = categoryRepository.findById(categoryDTO.getId()).get();
        category.setCategoryName(categoryDTO.getCategoryName());
        if(categoryDTO.getParentCategoryName() != null){
            category.setParentCategory(categoryRepository.findByName(categoryDTO.getParentCategoryName()).get());
        }
        category.setParentCategory(null);
        categoryRepository.save(category);
    }

    @Override
    public CategoryDTO get(String name) {
        Category category = categoryRepository.findByName(name).get();
        return CategoryMapper.categoryToCategoryDTOMapper(category);
    }

    @Override
    public CategoryDTO get(Integer id) throws EntityNotFoundServiceException {
        Category category;
        try {
            category = categoryRepository.findById(id).get();
        } catch (NoSuchElementException noSuchElementException) {
            throw new EntityNotFoundServiceException("The service couldn't find the desired category!", noSuchElementException);
        }

        return CategoryMapper.categoryToCategoryDTOMapper(category);
    }

    @Override
    public List<CategoryDTO> getAllSubcategories() {
        List<Category> listOfSubcategories = categoryRepository.findAllSubcategories();
        return CategoryMapper.listOfCategoriesToListOfCategoriesDTOMapper(listOfSubcategories);
    }

}
