package org.aalonzo.repository;

import org.aalonzo.domain.Topping;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToppingRepository extends CrudRepository<Topping,Long> {
}
