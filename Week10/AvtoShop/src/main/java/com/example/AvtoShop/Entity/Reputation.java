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
@Table (name = "Reputation")
public class Reputation {

    @Id
    @SequenceGenerator(name = "Reputation_seq",
            sequenceName = "Reputation_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Reputation_seq")
    @Column (name = "reputation_ID")
    private Long reputationID;

    private String reputation;

}