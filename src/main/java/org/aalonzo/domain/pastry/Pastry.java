package org.aalonzo.domain.pastry;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Pastry {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    private String name;

    public abstract double price();

    public abstract String name();

    public abstract String getName() ;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
