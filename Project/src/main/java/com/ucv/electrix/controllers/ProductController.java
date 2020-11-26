package com.ucv.electrix.controllers;

import com.ucv.electrix.dtos.ProductDTO;
import com.ucv.electrix.exceptions.services.ImageCreationException;
import com.ucv.electrix.services.CategoryService;
import com.ucv.electrix.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/add")
    public String getAddProductForm(Model model) {
        model.addAttribute("product", new ProductDTO());
        model.addAttribute("listOfSubcategories", categoryService.getAllSubcategories());
        return "add-product-form";
    }

    @PostMapping("/add")
    public String addProduct(@Valid @ModelAttribute("product") ProductDTO productDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("listOfSubcategories", categoryService.getAllSubcategories());
            return "add-product-form";
        }

        try {
            productService.add(productDTO);
        } catch (ImageCreationException imageCreationException) {
            model.addAttribute("error", imageCreationException);
        }

        return "redirect:/product/add";
    }

    @GetMapping("/delete")
    public String getDeleteProductForm(Model model){
        model.addAttribute("product", new ProductDTO());
        return "delete-product-form";
    }
}
