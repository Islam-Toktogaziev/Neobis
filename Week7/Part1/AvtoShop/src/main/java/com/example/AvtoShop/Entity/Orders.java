package com.example.AvtoShop.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Optional;


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

    @ManyToOne (fetch = FetchType.LAZY, optional = false)
    @JoinColumn (name = "customer_ID", referencedColumnName = "customer_ID")
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @OneToOne(optional = false)
    @JoinColumn (name = "shipping_ID", referencedColumnName = "shipping_ID")
    private Shipping shipping;

    @OneToOne(optional= false)
    @JoinColumn (name = "order_Details_ID",referencedColumnName = "order_Details_ID")
    private OrderDetails orderDetails;

    private String status;

}
