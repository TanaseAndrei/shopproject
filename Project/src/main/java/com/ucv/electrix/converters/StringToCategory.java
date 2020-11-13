package com.ucv.electrix.converters;

import com.ucv.electrix.dtos.CategoryDTO;
import com.ucv.electrix.mappers.CategoryMapper;
import com.ucv.electrix.models.Category;
import com.ucv.electrix.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class StringToCategory implements Converter<String, CategoryDTO> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryDTO convert(String s) {
        Category category = categoryRepository.findByName(s);
        return CategoryMapper.categoryToCategoryDTOMapper(category);
    }
}
