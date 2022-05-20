package org.aalonzo.domain.pastry;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Pastry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    public abstract double price();

    public abstract String name();

}
