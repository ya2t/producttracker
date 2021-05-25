package com.genesys.producttracker.controllers;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import com.genesys.producttracker.exceptions.RecordNotFoundException;
import com.genesys.producttracker.model.Product;
import com.genesys.producttracker.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1//products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllEmployees() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductByNumber(@PathVariable(value = "id") Long id) throws RecordNotFoundException  {
        Product product = productRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("No product for this product number " + id));
        return ResponseEntity.ok().body(product);
    }

    @PostMapping
    public Product createProduct(@Valid @RequestBody Product product){
        return productRepository.save(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Long number,
    @Valid @RequestBody Product productDetails) throws RecordNotFoundException {
        var product = productRepository.findById(number).orElseThrow(() -> new RecordNotFoundException("No product for this product number " + number));
        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setDiscontinued(productDetails.getDiscontinued());
        final var updatedProduct = productRepository.save(product);
        return ResponseEntity.ok(updatedProduct);
    }
}
