package com.app.inventory.infrastucture.model.jpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "packing")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PackingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idPacking;

    @Column
    private int quantity;

    @Column
    private double high;

    @Column
    private double width;

    @Column
    private double heigth;
}
