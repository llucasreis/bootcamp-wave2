package com.bootcamp.grupo4.productapi.services;

import com.bootcamp.grupo4.productapi.dto.ProductFormDTO;
import com.bootcamp.grupo4.productapi.entities.Product;
import com.bootcamp.grupo4.productapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(ProductFormDTO formDTO) {
        return this.productRepository.create(formDTO.convert());
    }

    @Override
    public Product update(Long id, ProductFormDTO formDTO) {
        return this.productRepository.update(id, formDTO.convert());
    }

    @Override
    public List<Product> findAll() {
        return this.productRepository.find();
    }

    @Override
    public Product findOne(Long id) {
        return this.productRepository.find(id);
    }

    @Override
    public boolean delete(Long id) {
        return this.productRepository.delete(id);
    }
}
