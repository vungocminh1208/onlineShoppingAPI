package com.ifi.onlineshopping.controller;

import com.ifi.onlineshopping.models.Product;
import com.ifi.onlineshopping.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping
    public List<Product> findAll() {
        return this.repository.findAll();
    }

    @GetMapping("{id}")
    public Product getById(@PathVariable Integer id) {
        return this.repository.getById(id);
    }

    @GetMapping("/search/{name}")
    public List<Product> getProductByName(@PathVariable(value = "name") String name) {
        return this.repository.findProductByNameContaining(name);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return this.repository.saveAndFlush(product);
    }

    @PutMapping("{id}")
    public Product updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        Product existingProduct = this.repository.getById(id);
        BeanUtils.copyProperties(product, existingProduct, "id");
        return this.repository.saveAndFlush(existingProduct);
    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable Integer id) {
        this.repository.deleteById(id);
    }



}
