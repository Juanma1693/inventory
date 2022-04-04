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
@DiscriminatorValue(value= PersonEntity.TYPE_EMPLOYEE)
public class EmployeeEntity extends PersonEntity {

    @Column
    private String position;


}
