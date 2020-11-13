package com.ucv.electrix.repositories;

import com.ucv.electrix.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
