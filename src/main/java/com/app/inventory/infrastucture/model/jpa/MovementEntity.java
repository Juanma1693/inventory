package com.app.inventory.infrastucture.model.jpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "movement")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idMovement;

    @ManyToOne
    @JoinColumn(name = "product_id_product")
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "id_packing")
    private PackingEntity packing;

    @ManyToOne
    @JoinColumn(name = "id_type_movement")
    private TypeMovementEntity typeMovement;

    @ManyToOne
    @JoinColumn(name = "employe_id_person")
    private EmployeeEntity employe;

    @ManyToOne
    @JoinColumn(name = "client_id_person")
    private ClientEntity client;


    @ManyToOne
    @JoinColumn(name = "origin_id_location")
    private LocationEntity origin;


    @ManyToOne
    @JoinColumn(name = "destination_id_location")
    private LocationEntity destination;

    @Column
    private String description;

}
