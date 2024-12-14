package com.example.ProductServiceAug24.joined_table;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Data
@Entity(name= "jt_mentors")
@PrimaryKeyJoinColumn(name = "User_id")
public class Mentor extends User {

    private String company;
    private double avg_rating;
}
