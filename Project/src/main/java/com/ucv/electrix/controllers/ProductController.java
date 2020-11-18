package com.ucv.electrix.controllers;

import com.ucv.electrix.dtos.ProductDTO;
import com.ucv.electrix.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public void addProduct(@ModelAttribute("product")ProductDTO productDTO, BindingResult bindingResult){
        productService.add(productDTO);
    }
}
