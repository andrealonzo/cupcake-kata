package org.aalonzo.repository;

import org.aalonzo.domain.Pastry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PastryRepository extends CrudRepository<Pastry,Long> {
}
