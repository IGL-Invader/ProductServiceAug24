package com.example.ProductServiceAug24.services;

import com.example.ProductServiceAug24.exceptions.ProductNotFoundException;
import com.example.ProductServiceAug24.models.Product;
import com.example.ProductServiceAug24.projections.ProductInfo;
import com.example.ProductServiceAug24.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("dbImpl")
public class ProductServiceImpl implements productService{

    @Autowired
    productRepository productRepository;

    @Override
    public Product getProductById(long id) throws ProductNotFoundException {

        ProductInfo ProductInfo = productRepository.getProductInfo(id);
        System.out.println(ProductInfo.getId());
        System.out.println(ProductInfo.getName());
        System.out.println(ProductInfo.getDescription());


        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            return product;
        }
        else{
            throw new ProductNotFoundException("Product with id " + id + " not available.");
        }
    }

    @Override
    public Product createProduct(String name, String category, String description) {

        /*
        select * from products where name == {name}
        if the above query returns a product, then don't create a new product
         */
        Product p = productRepository.findFirstByNameAndCategory(name, category);
        if(p != null) {
            return p;
        }

        Product product = new Product();
        product.setName(name);
        product.setCategory(category);
        product.setDescription(description);
        product = productRepository.save(product);
        System.out.println(product.getId());
        return product;
    }
}
