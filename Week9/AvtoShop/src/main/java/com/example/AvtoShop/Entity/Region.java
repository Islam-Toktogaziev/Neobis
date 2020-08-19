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
@Table (name = "Region")
public class Region {

    @Id
    @SequenceGenerator(name = "Region_seq",
            sequenceName = "Region_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Region_seq")
    @Column (name = "region_ID")
    private Long regionID;
    private String region;
}
