package com.ucv.electrix.services.implementations;

import com.ucv.electrix.dtos.ProductDTO;
import com.ucv.electrix.exceptions.EntityAlreadyExistsServiceException;
import com.ucv.electrix.exceptions.EntityNotFoundServiceException;
import com.ucv.electrix.mappers.ProductMapper;
import com.ucv.electrix.models.Product;
import com.ucv.electrix.repositories.CategoryRepository;
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

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void add(ProductDTO productDTO) {
        if(productRepository.findByName(productDTO.getName()) != null){
            throw new EntityAlreadyExistsServiceException("The entity " + productDTO.getName() + " already exists in the database!");
        } else {
            if(categoryRepository.findByName(productDTO.getCategory()) == null){
                throw new EntityNotFoundServiceException("The category " + productDTO.getName() + " does not exist!");
            } else {
                Product product = ProductMapper.productDTOToProductMapper(productDTO);
                product.setCategory(categoryRepository.findByName(productDTO.getCategory()).get());
                productRepository.save(product);
            }
        }
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Long id, ProductDTO productDTO) {

    }

    @Override
    public ProductDTO get(Long id) {
        return null;
    }

    @Override
    public List<ProductDTO> getAll() {
        return null;
    }
}
