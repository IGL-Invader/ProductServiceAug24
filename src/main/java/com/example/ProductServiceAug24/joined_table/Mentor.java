package com.example.ProductServiceAug24.mapped_super_class;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name= "msc_mentors")
public class Mentor extends User {

    private String company;
    private double avg_rating;
}
