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
@Entity
@Table (name = "Shipping")
public class Shipping {

    @Id
    @SequenceGenerator(name = "Shipping_seq",
             allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Shipping_seq")
    @Column (name = "shipping_ID")
    private Long shippingID;
    private String shippingType;
    private double shippingCost;

    @OneToOne (optional = false)
    @JoinColumn (name = "region_ID", referencedColumnName = "region_ID")
    private Region region;
}