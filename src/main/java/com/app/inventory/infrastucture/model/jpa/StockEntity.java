package com.app.inventory.infrastucture.model.jpa;

import com.app.inventory.infrastucture.model.jpa.CityEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "stock")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idStock;

    @Column
    private String name;

    @Column
    private String address;

    @ManyToOne
    @JoinColumn(name = "id_city")
    private CityEntity city;

}
