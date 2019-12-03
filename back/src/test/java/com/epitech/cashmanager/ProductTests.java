package com.epitech.cashmanager;

import com.epitech.cashmanager.model.Product;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.junit.Assert;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CashManagerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void testGetAllProducts() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/products",
                HttpMethod.GET, entity, String.class);

        Assert.assertNotNull(response.getBody());
    }

    @Test
    public void testGetProductById() {
        Product product = restTemplate.getForObject(getRootUrl() + "/products/1", Product.class);
        System.out.println(product.getName());
        Assert.assertNotNull(product);
    }

    @Test
    public void testCreateProduct() {
        Product product = new Product();
        product.setName("name");
        product.setPrice(10.0);

        ResponseEntity<Product> postResponse = restTemplate.postForEntity(getRootUrl() + "/products", product, Product.class);
        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdatePost() {
        int id = 1;
        Product product = restTemplate.getForObject(getRootUrl() + "/products/" + id, Product.class);
        product.setName("product1");

        restTemplate.put(getRootUrl() + "/products/" + id, product);

        Product updatedProduct = restTemplate.getForObject(getRootUrl() + "/products/" + id, Product.class);
        Assert.assertNotNull(updatedProduct);
    }

    @Test
    public void testDeletePost() {
        int id = 2;
        Product product = restTemplate.getForObject(getRootUrl() + "/products/" + id, Product.class);
        Assert.assertNotNull(product);

        restTemplate.delete(getRootUrl() + "/products/" + id);

        try {
            product = restTemplate.getForObject(getRootUrl() + "/products/" + id, Product.class);
        } catch (final HttpClientErrorException e) {
            Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

}
