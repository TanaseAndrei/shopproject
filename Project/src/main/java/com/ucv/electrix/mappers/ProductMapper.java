package com.ucv.electrix.mappers;

import com.ucv.electrix.dtos.ProductDTO;
import com.ucv.electrix.models.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

    public static Product productDTOToProductMapper(ProductDTO productDTO){
        Product product = new Product();
        product.setBrand(productDTO.getBrand());
        product.setCategory(productDTO.getCategory());
        product.setDetails(productDTO.getDetails());
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setStock(productDTO.getStock());
        return product;
    }

    public static ProductDTO productToProductDTOMapper(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setBrand(product.getBrand());
        productDTO.setCategory(product.getCategory());
        productDTO.setDetails(product.getDetails());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setStock(product.getStock());
        return productDTO;
    }

    public static List<ProductDTO> listOfProductsToListOfProductsDTOMapper(List<Product> listOfProducts){
        return listOfProducts
                .stream()
                .map(ProductMapper::productToProductDTOMapper)
                .collect(Collectors.toList());
    }
}
