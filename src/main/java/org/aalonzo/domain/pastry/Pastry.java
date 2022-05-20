package org.aalonzo.domain.pastry;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public interface Pastry {
    double price();
    String name();
}
