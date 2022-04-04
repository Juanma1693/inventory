package com.app.inventory.infrastucture.model.jpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "location")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LocationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idLocation;

    @Column
    private String name;

    @Column
    private double high;

    @Column
    private double width;

    @Column
    private double heigth;

}
