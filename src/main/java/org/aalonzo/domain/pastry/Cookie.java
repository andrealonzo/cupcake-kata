package org.aalonzo.domain.pastry;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Cookie implements Pastry {
    @Id
    @GeneratedValue
    private Long id;
    public static final int PRICE = 2;
    public static final String COOKIE = "Cookie";

    @Override
    public String name() {
        return COOKIE;
    }


    public double price() {
        return PRICE;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
