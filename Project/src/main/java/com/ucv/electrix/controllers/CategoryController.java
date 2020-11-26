package com.ucv.electrix.controllers;

import com.ucv.electrix.dtos.CategoryDTO;
import com.ucv.electrix.exceptions.services.EntityNotFoundServiceException;
import com.ucv.electrix.services.CategoryService;
import com.ucv.electrix.validators.groups.CreateCategory;
import com.ucv.electrix.validators.groups.CreateSubcategory;
import com.ucv.electrix.validators.groups.DeleteCategory;
import com.ucv.electrix.validators.groups.UpdateCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("/add-category")
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
        return "redirect:/category/add-category";
    }

    @GetMapping("/add-subcategory")
    public String getSubcategoryForm(Model model){
        model.addAttribute("category", new CategoryDTO());
        model.addAttribute("parentCategories", categoryService.getParentCategories());
        return "add-subcategory-form";
    }

    @PostMapping("/add-subcategory")
    public String addSubcategory(@Validated(CreateSubcategory.class) @ModelAttribute("category") CategoryDTO categoryDTO, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("parentCategories", categoryService.getParentCategories());
            return "add-subcategory-form";
        }
        categoryService.add(categoryDTO);
        return "redirect:/category/add-subcategory";
    }

    @GetMapping("/delete")
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

    @GetMapping("/update/{id}")
    public String getUpdateCategoryForm(@PathVariable("id") Integer id, Model model) throws EntityNotFoundServiceException {
        try {
            model.addAttribute("category", categoryService.get(id));
        } catch (EntityNotFoundServiceException entityNotFoundServiceException){
            throw entityNotFoundServiceException;
        }
        return "update-category-form";
    }

    @PutMapping("/update")
    public String updateCategory(@Validated(UpdateCategory.class) @ModelAttribute("category") CategoryDTO categoryDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "delete-category-form";
        }
        categoryService.update(categoryDTO);
        return "index";
    }

    @ExceptionHandler(EntityNotFoundServiceException.class)
    public String handleEntityNotFoundException(EntityNotFoundServiceException entityNotFoundServiceException){
        return "exceptions/entity-not-found";
    }

}
