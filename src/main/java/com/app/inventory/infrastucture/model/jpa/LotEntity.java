package com.app.inventory.infrastucture.model.jpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "lot")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LotEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idLot;

    @Column
    private LocalDate entryDate;

    @Column
    private LocalDate dueDate;

    @Column
    private long quantity;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "id_packing")
    private PackingEntity packing;

}
