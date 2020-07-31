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
@Entity (name = "Employee")
@Table (name = "Employees")
public class Employee {

    @Id
    @SequenceGenerator(name = "Employee_seq",
    sequenceName = "Employee_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Employee_seq")
    @Column (name = "employee_ID")
    private Long employeeID;

    private String employeeName;

    @ManyToOne
    @JoinColumn (name = "position_ID", referencedColumnName = "position_ID")
    private Position positionID;

    private double salary;
    private String address;
    private String email;
    private String number;

}
