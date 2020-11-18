package com.ucv.electrix.repositories;

import com.ucv.electrix.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select p from Product p where p.name = ?1")
    Optional<Product> findByName(String name);
}
