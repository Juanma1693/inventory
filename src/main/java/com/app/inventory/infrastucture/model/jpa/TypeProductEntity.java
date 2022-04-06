package com.app.inventory.infrastucture.model.jpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "type_product")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TypeProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTypeProduct;

    @Column
    private String name;

}