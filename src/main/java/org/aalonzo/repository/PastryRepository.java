package org.aalonzo.repository;

import org.aalonzo.domain.PastryWithToppings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PastryRepository extends CrudRepository<PastryWithToppings,Long> {
}
