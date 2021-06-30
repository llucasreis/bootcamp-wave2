package com.bootcamp.grupo4.productapi.repository;

import com.bootcamp.grupo4.productapi.entities.Product;

import java.util.List;

public interface ProductRepository {
    Product create(Product product);
    Product update(Long id, Product product);
    List<Product> find();
    Product find(Long id);
    boolean delete(Long id);
}
