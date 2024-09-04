package com.example.ProductServiceAug24.services;

import com.example.ProductServiceAug24.Dtos.FakeStoreDto;
import com.example.ProductServiceAug24.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements productService{
    @Override
    public Product getProductById(long id) {
        /*
        we will take the id from input and call this endpoint:
        'https://fakestoreapi.com/products + {id}
         */
        String url = "https://fakestoreapi.com/products/" + id;
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreDto FakeStoreDto = restTemplate.getForObject(url, FakeStoreDto.class);

        return convertFakeStoreToProduct(FakeStoreDto);

    }

    private Product convertFakeStoreToProduct(FakeStoreDto Dto){

        Product product = new Product();
        product.setName(Dto.getTitle());
        product.setDescription(Dto.getDescription());
        product.setCategory(Dto.getCategory());

        return product;

    }

}

