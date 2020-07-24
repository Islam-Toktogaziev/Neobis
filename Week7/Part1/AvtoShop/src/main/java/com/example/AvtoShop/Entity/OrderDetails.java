package com.example.AvtoShop.Entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "OrderDetails")
public class OrderDetails {

    @Id
    @SequenceGenerator(name = "OrderDetails_seq",
            sequenceName = "OrderDetails_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OrderDetails_seq")
    @Column (name = "order_Details_ID")
    private Long orderDetailsID;

    @OneToMany (cascade = CascadeType.ALL, targetEntity = Car.class)
    private Set<Car> car = new HashSet<>();

    private double total = getTotal(car);


    private double getTotal (Set<Car> car){
        double sum=0;
        for (Car car1: car) {
            sum+=car1.getPriceID().getPrice();
        }
        return sum;
    }

}