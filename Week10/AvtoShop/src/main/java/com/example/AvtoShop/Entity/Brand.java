package com.example.AvtoShop.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Brand {

    @Id
    @SequenceGenerator(name = "brand_seq",
            sequenceName = "brand_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "brand_seq")
    @Column (name = "brand_ID")
    private Long brandID;

    private String brand;
}
