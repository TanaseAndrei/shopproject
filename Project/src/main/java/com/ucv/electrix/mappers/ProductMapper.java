package com.ucv.electrix.mappers;

import com.ucv.electrix.dtos.ProductDTO;
import com.ucv.electrix.models.Product;

public class ProductMapper {

    public static Product productDTOToProductMapper(ProductDTO productDTO){
        Product product = new Product();
        product.setBrand(productDTO.getBrand());
        product.setStock(productDTO.getStock());
        product.setDetails(productDTO.getDetails());
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
//        product.setCategory(productDTO.getCategory());
        return product;
    }

}
