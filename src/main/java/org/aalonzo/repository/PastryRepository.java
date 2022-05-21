package org.aalonzo.repository;

import org.aalonzo.domain.pastry.Pastry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PastryRepository extends CrudRepository<Pastry,Long> {
}
