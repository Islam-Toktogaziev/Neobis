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
@Entity (name = "customers")
public class Customer {

    @Id
    @SequenceGenerator(name = "Customer_seq",
            sequenceName = "Customer_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Customer_seq")
    @Column (name = "customer_ID")
    private Long customerID;
    private String customerName;

    @ManyToOne
    @JoinColumn (name = "reputation_ID", referencedColumnName = "reputation_ID")
    private Reputation reputationID;

    private String address;
    private String email;
    private String number;
}
