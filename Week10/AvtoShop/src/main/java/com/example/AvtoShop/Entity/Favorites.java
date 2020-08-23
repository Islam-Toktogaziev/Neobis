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
@Table (name = "favorites")
public class Favorites {

    @Id
    @SequenceGenerator(name = "favorites_seq",
            sequenceName = "favorites_seq",
            allocationSize = 1)
    @GeneratedValue (strategy = GenerationType.SEQUENCE,
            generator = "favorites_seq")
    @Column(name = "favorites_ID")
    private Long favoritesID;

    @OneToOne
    @JoinColumn (name = "customer_ID", referencedColumnName = "customer_ID")
    private Customer customerID;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Favorites_Car",
            joinColumns = { @JoinColumn(name = "favorites_ID") },
            inverseJoinColumns = { @JoinColumn(name = "car_ID") })
    private Set<Car> cars = new HashSet<>();

}
