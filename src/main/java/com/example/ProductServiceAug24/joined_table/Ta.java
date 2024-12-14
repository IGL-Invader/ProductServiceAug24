package com.example.ProductServiceAug24.mapped_super_class;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "msc_Tas")
public class Ta extends User{

    private int noofques;
    private String college;
}
