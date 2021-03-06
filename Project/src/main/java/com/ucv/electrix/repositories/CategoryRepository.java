package com.ucv.electrix.repositories;

import com.ucv.electrix.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = "select category from Category category where category.categoryName = ?1")
    Optional<Category> findByName(String name);

    @Query(value = "select category from Category category where category.parentCategory is null")
    List<Category> findParentCategories();

    @Query(value = "select category from Category category where category.parentCategory.categoryName=?1")
    List<Category> findAllByParentCategory(String name);

    @Query(value = "select category from Category category where category.parentCategory is not null")
    List<Category> findAllSubcategories();
}
