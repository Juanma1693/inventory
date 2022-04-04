package com.app.inventory.infrastucture.model.jpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "inventory")
@Builder(toBuilder=true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class InventoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idInventory;

    @Column
    private long quantity;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "id_packing")
    private PackingEntity packing;

}
