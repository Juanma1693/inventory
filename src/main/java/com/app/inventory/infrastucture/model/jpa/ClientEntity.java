package com.app.inventory.infrastucture.model.jpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue(value= PersonEntity.TYPE_CLIENT)
public class ClientEntity extends PersonEntity {


    @Column
    private String companyName;

    @Column
    private String companyIdentification;

}
