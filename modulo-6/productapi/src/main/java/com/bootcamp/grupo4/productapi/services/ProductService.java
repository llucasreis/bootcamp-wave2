package com.bootcamp.grupo4.productapi.services;

import com.bootcamp.grupo4.productapi.dto.ProductFormDTO;
import com.bootcamp.grupo4.productapi.entities.Product;
import com.bootcamp.grupo4.productapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(ProductFormDTO formDTO) {
        return this.productRepository.create(formDTO.convert());
    }

    public Product update(Long id, ProductFormDTO formDTO) {
        return this.productRepository.update(id, formDTO.convert());
    }

    public List<Product> findAll() {
        return this.productRepository.find();
    }

    public Product findOne(Long id) {
        return this.productRepository.find(id);
    }

    public boolean delete(long id) {
        return this.productRepository.delete(id);
    }
}
