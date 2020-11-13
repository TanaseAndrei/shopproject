package com.ucv.electrix.services.implementations;

import com.ucv.electrix.dtos.ProductDTO;
import com.ucv.electrix.exceptions.EntityNotFoundServiceException;
import com.ucv.electrix.mappers.ProductMapper;
import com.ucv.electrix.models.Product;
import com.ucv.electrix.repositories.ProductRepository;
import com.ucv.electrix.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void add(ProductDTO productDTO) {
        Product product = ProductMapper.productDTOToProductMapper(productDTO);
        productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundServiceException("The service did not find the searched product to delete!"));
        productRepository.delete(product);
    }

    @Override
    public void update(Long id, ProductDTO productDTO) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundServiceException("The service did not find the searched product to update!"));
        product.setStock(productDTO.getStock());
        product.setPrice(productDTO.getPrice());
        product.setName(productDTO.getName());
        product.setDetails(productDTO.getDetails());
        product.setCategory(productDTO.getCategory());
        product.setBrand(productDTO.getBrand());
        productRepository.save(product);
    }

    @Override
    public ProductDTO get(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundServiceException("The service did not find the searched product!"));
        return ProductMapper.productToProductDTOMapper(product);
    }

    @Override
    public List<ProductDTO> getAll() {
        List<Product> listOfProducts = productRepository.findAll();
        return ProductMapper.listOfProductsToListOfProductsDTOMapper(listOfProducts);
    }
}
