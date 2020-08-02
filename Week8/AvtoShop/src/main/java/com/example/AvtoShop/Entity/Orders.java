package com.example.AvtoShop.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity (name = "Orders")
@Table (name = "Orders")
public class Orders extends AuditModel implements Serializable {

    @Id
    @SequenceGenerator(name = "Order_seq",
            sequenceName = "Order_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Order_seq")
    @Column (name = "order_ID")
    private Long orderID;

    @ManyToOne
    @JoinColumn (name = "customer_ID", referencedColumnName = "customer_ID")
    private Customer customerID;

    @OneToOne
    @JoinColumn (name = "shipping_ID", referencedColumnName = "shipping_ID")
    private Shipping shippingID;

    @ManyToOne
    @JoinColumn (name = "car_ID",referencedColumnName = "car_ID")
    private Car carID;

    private String status;

}
