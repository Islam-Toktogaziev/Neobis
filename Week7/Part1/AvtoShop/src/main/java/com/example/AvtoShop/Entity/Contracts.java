package com.example.AvtoShop.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "Contracts")
public class Contracts extends AuditModel {

    @Id
    @SequenceGenerator(name = "Contracts_seq",
            sequenceName = "Contracts_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Contracts_seq")
    @Column (name = "contract_ID")
    private Long contractID;

    @OneToOne
    @JoinColumn (name = "order_ID", referencedColumnName = "order_ID")
    private Orders orderID;

    @OneToOne
    @JoinColumn (name = "employee_ID",referencedColumnName = "employee_ID")
    private Employee employeeID;

    @OneToOne
    @JoinColumn (name = "customer_ID", referencedColumnName = "customer_ID")
    private Customer customerID;

    @OneToOne
    @JoinColumn (name = "car_ID", referencedColumnName = "car_ID")
    private Car carID ;

    @OneToOne
    @JoinColumn(name = "price_ID", referencedColumnName = "price_ID")
    private PriceList priceID;

    @OneToOne
    @JoinColumn (name = "shipping_ID", referencedColumnName = "shipping_ID")
    private Shipping shippingID;

}
