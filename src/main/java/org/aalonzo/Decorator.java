package org.aalonzo;

public interface Decorator {
     Decorator getInner();

    double price();
}
