package com.example.ProductServiceAug24.joined_table;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Data
@Entity(name = "jt_Tas")
@PrimaryKeyJoinColumn(name = "User_id")
public class Ta extends User {

    private int noofques;
    private String college;
}
