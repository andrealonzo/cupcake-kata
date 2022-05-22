package org.aalonzo.domain.topping;

import org.aalonzo.domain.pastry.Pastry;

import javax.persistence.*;

@Entity
public class Topping extends Pastry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
