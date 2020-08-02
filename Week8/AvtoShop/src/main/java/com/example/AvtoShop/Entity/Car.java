package com.example.AvtoShop.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity (name = "Car")
@Table ( name = "Cars")
public class Car {

    @Id
    @SequenceGenerator(name = "Customer_seq",
            sequenceName = "Customer_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Customer_seq")
    @Column (name = "car_ID")
    private Long carID;

    private String carName;

    @ManyToOne
    @JoinColumn (name = "car_Type_ID", referencedColumnName = "car_Type_ID")
    private CarType carType;

    @ManyToOne
    @JoinColumn (name = "price_ID", referencedColumnName = "price_ID")
    private PriceList priceID;

    private String color;
    private double engineDisplacement;

}
