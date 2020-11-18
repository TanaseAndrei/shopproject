package com.ucv.electrix.controllers;

import com.ucv.electrix.dtos.CategoryDTO;
import com.ucv.electrix.services.CategoryService;
import com.ucv.electrix.validators.validated.CreateCategory;
import com.ucv.electrix.validators.validated.CreateSubcategory;
import com.ucv.electrix.validators.validated.DeleteCategory;
import com.ucv.electrix.validators.validated.UpdateCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category-form")
    public String getParentCategoryForm(Model model){
        model.addAttribute("category",new CategoryDTO());
        return "add-category-form";
    }

    @PostMapping("/add-category")
    public String addCategory(@Validated(CreateCategory.class) @ModelAttribute("category") CategoryDTO categoryDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "add-category-form";
        }
        categoryService.add(categoryDTO);
        return "redirect:/category/category-form";
    }

    @GetMapping("/subcategory-form")
    public String getSubcategoryForm(Model model){
        model.addAttribute("category", new CategoryDTO());
        model.addAttribute("parentCategories", categoryService.getParentCategories());
        return "add-subcategory-form";
    }

    @PostMapping("/add-subcategory")
    public String addSubcategory(@Validated(CreateSubcategory.class) @ModelAttribute("category") CategoryDTO categoryDTO, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "add-subcategory-form";
        }
        categoryService.add(categoryDTO);
        return "redirect:/category/subcategory-form";
    }

    @GetMapping("/delete-category-form")
    public String getDeleteCategoryForm(Model model){
        model.addAttribute("category", new CategoryDTO());
        return "delete-category-form";
    }

    @DeleteMapping("/delete")
    public String deleteCategory(@Validated(DeleteCategory.class) @ModelAttribute("category") CategoryDTO categoryDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "delete-category-form";
        }
        categoryService.delete(categoryDTO);
        return "index";
    }

    @PutMapping("/update/{name}")
    public String updateCategory(@Validated(UpdateCategory.class) CategoryDTO categoryDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return null;
        }
        categoryService.delete(categoryDTO);
        return "index";
    }

}
