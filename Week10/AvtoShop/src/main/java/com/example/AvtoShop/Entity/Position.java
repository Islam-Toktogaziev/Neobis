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
@Table (name = "Position")
public class Position {

    @Id
    @SequenceGenerator(name = "Position_seq",
            sequenceName = "Position_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Position_seq")
    @Column (name = "position_ID")
    private Long positionID;
    private String position;
}
