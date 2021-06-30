package com.bootcamp.grupo4.productapi.repository;

import com.bootcamp.grupo4.productapi.entities.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepository {
    private List<Product> products;

    public ProductRepository() {
        this.products = new ArrayList<>();
    }

    private Long getId() {
        if (this.products.size() == 0) {
            return 1L;
        }
        Product lastProduct = this.products.get(this.products.size() - 1);
        return lastProduct.getId() + 1;
    }

    public Product create(Product product) {
        product.setId(this.getId());
        this.products.add(product);

        return product;
    }

    public Product update(Long id, Product product) {
        int arrayIndex = -1;
        for (int i = 0; i< this.products.size(); i++) {
            if (this.products.get(i).getId().equals(id)) {
                arrayIndex = i;
            }
        }

        if (arrayIndex >= 0) {
            this.products.get(arrayIndex).setNome(product.getNome());
            this.products.get(arrayIndex).setQuantidade(product.getQuantidade());

            return this.products.get(arrayIndex);
        } else {
            return null;
        }
    }

    public List<Product> find() {
        return this.products;
    }

    public Product find(Long id) {
        return this.products.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    public boolean delete(Long id) {
        Optional<Product> product = this.products.stream().filter(p -> p.getId().equals(id)).findFirst();

        if (product.isPresent()) {
            this.products.remove(product.get());
            return true;
        } else {
            return false;
        }
    }
}
