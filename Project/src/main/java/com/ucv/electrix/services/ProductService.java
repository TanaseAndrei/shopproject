package com.ucv.electrix.services;

import com.ucv.electrix.dtos.ProductDTO;
import com.ucv.electrix.exceptions.services.ImageCreationException;

import java.util.List;

public interface ProductService {
    void add(ProductDTO product) throws ImageCreationException;

    void delete(String name);

    void update(ProductDTO productDTO);

    ProductDTO get(Long id);

    List<ProductDTO> getAll();
}
