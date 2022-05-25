package org.aalonzo.repository;

import org.aalonzo.domain.Pastry;
import org.aalonzo.domain.PastryType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PastryTypeRepository extends CrudRepository<PastryType,Long> {
}
