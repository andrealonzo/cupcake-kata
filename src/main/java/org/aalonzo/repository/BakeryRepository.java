package org.aalonzo.repository;

import org.aalonzo.domain.BakeryOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BakeryRepository extends CrudRepository<BakeryOrder,Long> {
}
