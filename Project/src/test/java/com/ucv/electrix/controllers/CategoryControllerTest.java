package com.ucv.electrix.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test_addCategoryForm() throws Exception {
        mockMvc.perform(get("/category/category-form"))
                .andExpect(status().isOk())
                .andExpect(view().name("add-category-form"));
    }

    @Test
    public void test_addSubcategoryForm() throws Exception {
        mockMvc.perform(get("/category/subcategory-form"))
                .andExpect(status().isOk())
                .andExpect(view().name("add-subcategory-form"));
    }

}
