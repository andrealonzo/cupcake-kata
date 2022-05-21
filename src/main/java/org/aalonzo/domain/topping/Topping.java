package org.aalonzo.domain.topping;

import org.aalonzo.domain.pastry.Pastry;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Topping extends Pastry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public Topping(){

    }

}
