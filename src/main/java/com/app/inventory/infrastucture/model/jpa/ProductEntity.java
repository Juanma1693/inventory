package com.app.inventory.infrastucture.model.jpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProduct;

    @Column
    private String name;

    @Column
    private BigDecimal price;


    @ManyToOne
    @JoinColumn(name = "id_packing")
    private PackingEntity packing;


    @ManyToOne
    @JoinColumn(name = "id_type_product")
    private TypeProductEntity typeProduct;

}
