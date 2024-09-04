package com.example.ProductServiceAug24.controllers;

import com.example.ProductServiceAug24.models.Product;
import com.example.ProductServiceAug24.services.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private productService productService;

    //GET /product/{id}
    @GetMapping("/product/{id}")

    public ResponseEntity<Product> getProductByID(@PathVariable("id") long productID) {

        if( productID < 0 || productID > 20 ) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }
        Product product = productService.getProductById(productID);
        return new ResponseEntity<>(product,HttpStatusCode.valueOf(200));

    }
}
