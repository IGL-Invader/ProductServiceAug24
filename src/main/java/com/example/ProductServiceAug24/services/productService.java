package com.example.ProductServiceAug24.services;

import com.example.ProductServiceAug24.exceptions.ProductNotFoundException;
import com.example.ProductServiceAug24.models.Product;
import org.springframework.data.domain.Page;

public interface productService {

    public Product getProductById(long id)throws ProductNotFoundException;

    public Product createProduct(String name, String category, String description);

    public Page<Product> getAllProducts(int pageSize, int pageNum);


}
