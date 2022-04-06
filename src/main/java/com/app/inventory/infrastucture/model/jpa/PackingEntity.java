package com.app.inventory.infrastucture.model.jpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "packing")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PackingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPacking;

    @Column
    private int quantity;

    @Column
    private double high;

    @Column
    private double width;

    @Column
    private double height;
}
