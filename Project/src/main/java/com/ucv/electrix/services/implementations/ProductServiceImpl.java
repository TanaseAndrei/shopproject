package com.ucv.electrix.services.implementations;

import com.ucv.electrix.dtos.ProductDTO;
import com.ucv.electrix.exceptions.services.ImageCreationException;
import com.ucv.electrix.mappers.ProductMapper;
import com.ucv.electrix.models.Product;
import com.ucv.electrix.repositories.CategoryRepository;
import com.ucv.electrix.repositories.ProductRepository;
import com.ucv.electrix.services.ProductService;
import com.ucv.electrix.utils.interfaces.ImageCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ImageCreator imageCreator;

    @Override
    public void add(ProductDTO productDTO) throws ImageCreationException  {
        try {
            Product product = ProductMapper.productDTOToProductMapper(productDTO);
            product.setCategory(categoryRepository.findByName(productDTO.getCategory()).get());
            product.setProductImageName(imageCreator.createPicture(productDTO.getMultipartFile()));
            productRepository.save(product);
        } catch (IOException ioException) {
            throw new ImageCreationException("The product's image could not be created!", ioException);
        }
    }

    @Override
    public void delete(String name) {
    }

    @Override
    public void update(ProductDTO productDTO) {
    }

    @Override
    public ProductDTO get(Long id) {
        return null;
    }

    @Override
    public List<ProductDTO> getAll() {
        return null;
    }

    private void createPicture(MultipartFile multipartFile) throws IOException {

    }
}
