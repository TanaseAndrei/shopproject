package com.ucv.electrix.mappers;

import com.ucv.electrix.dtos.ProductDTO;
import com.ucv.electrix.models.Product;

public class ProductMapper {

    public static Product productDTOToProductMapper(ProductDTO productDTO){
        Product product = new Product();
        product.setBrand(productDTO.getBrand());
        product.setStock(productDTO.getStock());
        product.setDetails(productDTO.getDetails());
        product.setName(product.getName());
        product.setPrice(product.getPrice());
        return product;
    }

}
