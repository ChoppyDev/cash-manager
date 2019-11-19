package com.epitech.cashmanager.controller;

import com.epitech.cashmanager.model.Product;
import com.epitech.cashmanager.repository.ProductRepository;
import com.epitech.cashmanager.exception.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Get all products list.
     *
     * @return the list
     */
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Gets products by id.
     *
     * @param productId the user id
     * @return the users by id
     * @throws ResourceNotFound the resource not found exception
     */

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductsById(@PathVariable(value = "id") Long productId)
            throws ResourceNotFound {
        Product product =
                productRepository
                        .findById(productId)
                        .orElseThrow(() -> new ResourceNotFound("Product not found on :: " + productId));
        return ResponseEntity.ok().body(product);
    }

    /**
     * Create product.
     *
     * @param product the product
     * @return the product
     */
    @PostMapping("/products")
    public Product createProduct(@Valid @RequestBody Product product) {
        return productRepository.save(product);
    }

    /**
     * Update product response entity.
     *
     * @param productId the user id
     * @param productDetails the product details
     * @return the response entity
     * @throws ResourceNotFound the resource not found exception
     */
    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable(value = "id") Long productId, @Valid @RequestBody Product productDetails)
            throws ResourceNotFound {

        Product product =
                productRepository
                        .findById(productId)
                        .orElseThrow(() -> new ResourceNotFound("Product not found on :: " + productId));

        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        product.setQuantity(productDetails.getQuantity());
        product.setUpdatedAt(new Date());
        product.setCreatedAt(new Date());
        product.setCreatedBy("User");
        final Product updatedProduct = productRepository.save(product);
        return ResponseEntity.ok(updatedProduct);
    }

    /**
     * Delete product map.
     *
     * @param productId the product id
     * @return the map
     * @throws Exception the exception
     */
    @DeleteMapping("/product/{id}")
    public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") Long productId) throws Exception {
        Product product =
                productRepository
                        .findById(productId)
                        .orElseThrow(() -> new ResourceNotFound("Product not found on :: " + productId));

        productRepository.delete(product);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}