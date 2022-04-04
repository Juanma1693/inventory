package com.app.inventory.infrastucture.model.jpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "city")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCity;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_state")
    private StateEntity state;

}