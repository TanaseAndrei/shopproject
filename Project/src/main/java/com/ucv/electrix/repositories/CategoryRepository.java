package com.ucv.electrix.repositories;

import com.ucv.electrix.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = "select c from Category c where c.categoryName = ?1")
    Category findByName(String name);

    @Query(value = "select c from Category c where c.parentCategory is null")
    List<Category> findParentCategories();
}
