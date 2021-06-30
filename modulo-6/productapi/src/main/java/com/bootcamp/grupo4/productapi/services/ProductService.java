package com.bootcamp.grupo4.productapi.services;

import com.bootcamp.grupo4.productapi.dto.ProductFormDTO;
import com.bootcamp.grupo4.productapi.entities.Product;

import java.util.List;

public interface ProductService {

    Product create(ProductFormDTO formDTO);
    Product update(Long id, ProductFormDTO formDTO);
    List<Product> findAll();
    Product findOne(Long id);
    boolean delete(Long id);
}
