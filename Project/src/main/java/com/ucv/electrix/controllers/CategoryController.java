package com.ucv.electrix.controllers;

import com.ucv.electrix.dtos.CategoryDTO;
import com.ucv.electrix.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String addParentCategory(@ModelAttribute("category") CategoryDTO categoryDTO){
        categoryService.add(categoryDTO);
        return "redirect:/";
    }

    @GetMapping("/subcategory-form")
    public String getSubcategoryForm(Model model){
        List<CategoryDTO> listOfParentCategories = categoryService.getParentCategories();
        model.addAttribute("category", new CategoryDTO());
        model.addAttribute("parentCategories", listOfParentCategories);
        return "add-subcategory-form";
    }

    @PostMapping("/add-subcategory")
    public String addSubcategory(@ModelAttribute("category") CategoryDTO categoryDTO, BindingResult bindingResult){
        categoryService.addSubcategory(categoryDTO);
        return "redirect:/";
    }

}
