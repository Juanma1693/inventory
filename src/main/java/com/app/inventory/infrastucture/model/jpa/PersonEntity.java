package com.app.inventory.infrastucture.model.jpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "person")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType=DiscriminatorType.STRING)
public abstract class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idPerson;

    @Column
    private String identification;

    @Column
    private String name;

    protected static final String TYPE_CLIENT = "CLIENT";

    protected static final String TYPE_EMPLOYEE = "EMPLOYEE";

}
