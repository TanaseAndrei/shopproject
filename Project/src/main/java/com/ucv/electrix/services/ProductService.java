package com.ucv.electrix.services;

import com.ucv.electrix.dtos.ProductDTO;

import java.util.List;

public interface ProductService {
    void add(ProductDTO product);
    void delete(Long id);
    void update(Long id, ProductDTO productDTO);
    ProductDTO get(Long id);
    List<ProductDTO> getAll();
}
