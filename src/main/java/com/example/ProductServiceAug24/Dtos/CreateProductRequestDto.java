package com.example.ProductServiceAug24.Dtos;

import lombok.Data;

@Data
public class CreateProductRequestDto {
    String name;
    String category;
    String description;

}
