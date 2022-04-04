package com.app.inventory.infrastucture.model.jpa;

import com.app.inventory.infrastucture.model.jpa.CountryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "state")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idState;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_country")
    private CountryEntity country;

}