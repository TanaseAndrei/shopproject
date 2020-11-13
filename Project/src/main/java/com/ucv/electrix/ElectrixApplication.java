package com.ucv.electrix;

import com.ucv.electrix.controllers.HomeController;
import com.ucv.electrix.controllers.ProductController;
import com.ucv.electrix.services.CategoryService;
import com.ucv.electrix.services.implementations.CategoryServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class ElectrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(ElectrixApplication.class, args);
    }
}
