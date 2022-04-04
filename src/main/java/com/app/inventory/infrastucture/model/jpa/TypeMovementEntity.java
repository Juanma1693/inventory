package com.app.inventory.infrastucture.model.jpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "type_movement")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TypeMovementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTypeMovement;

    @Column
    private String name;

}