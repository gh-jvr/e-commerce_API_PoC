package jvr.poc.price.repositories;

import jvr.poc.price.entities.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Repository which is in charge of DB access.
 */
public interface PriceRepository extends JpaRepository<Price,Long>, JpaSpecificationExecutor<Price> {
}
