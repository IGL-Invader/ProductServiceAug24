package com.example.ProductServiceAug24.services;

import com.example.ProductServiceAug24.Dtos.FakeStoreDto;
import com.example.ProductServiceAug24.exceptions.ProductNotFoundException;
import com.example.ProductServiceAug24.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("fakeStore")
public class FakeStoreProductService implements productService{
    @Override
    public Product getProductById(long id) throws ProductNotFoundException {
        /*
        we will take the id from input and call this endpoint:
        'https://fakestoreapi.com/products + {id}
         */
        String url = "https://fakestoreapi.com/products/" + id;
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreDto FakeStoreDto = restTemplate.getForObject(url, FakeStoreDto.class);

        if(FakeStoreDto == null) {
            throw new ProductNotFoundException("Product with id- " + id +" was not found");
        }

        return convertFakeStoreToProduct(FakeStoreDto);

    }

    @Override
    public Product createProduct(String name, String category, String description) {
        return null;
    }

    @Override
    public Page<Product> getAllProducts(int pageSize, int pageNum) {
        return null;
    }


    private Product convertFakeStoreToProduct(FakeStoreDto Dto){

        Product product = new Product();
        product.setName(Dto.getTitle());
        product.setDescription(Dto.getDescription());
        product.setCategory(Dto.getCategory());

        return product;

    }



}

