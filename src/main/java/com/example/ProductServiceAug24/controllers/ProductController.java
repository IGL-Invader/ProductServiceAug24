package com.example.ProductServiceAug24.controllers;

import com.example.ProductServiceAug24.Dtos.CreateProductRequestDto;
import com.example.ProductServiceAug24.exceptions.ProductNotFoundException;
import com.example.ProductServiceAug24.models.Product;
import com.example.ProductServiceAug24.services.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    @Qualifier("dbImpl")
    private productService productService;


    //GET /product/{id}
    @GetMapping(" /{id}")
    public ResponseEntity<Product> getProductByID(@PathVariable("id") long productID) throws ProductNotFoundException {

        //if( productID < 0 || productID > 20 ) {
        //    return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        //}
        Product product = productService.getProductById(productID);
        return new ResponseEntity<>(product,HttpStatusCode.valueOf(200));

    }
    @PostMapping
    public Product createProduct(CreateProductRequestDto requestDto) {
        /*
        add basic validations
        if(requestDto.getName = NULL){
            throw new exception;
         */
        System.out.println(requestDto);
        return productService.createProduct(requestDto.getName(), requestDto.getCategory(), requestDto.getDescription());
    }

    @GetMapping()
    public ResponseEntity<Page<Product>> getAllProducts(
            @RequestParam(value = "pageSize", defaultValue = "20") int pageSize,
            @RequestParam(value = "pageNum", defaultValue = "0") int pageNum
    ) {


        Page<Product> products = productService.getAllProducts(pageSize, pageNum);
        return ResponseEntity.ok(products);
    }

}
