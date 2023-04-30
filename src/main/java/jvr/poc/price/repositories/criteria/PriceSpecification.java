package jvr.poc.price.repositories.criteria;

import jvr.poc.price.entities.Price;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;

/**
 * Specification Price class which is in charge of building queries to access to DB.
 */
@AllArgsConstructor
public class PriceSpecification implements Specification<Price> {

    /**
     * Search criteria instance.
     */
    private SearchCriteria criteria;

    /**
     * Implementation of toPredicate method in charge of generating a custom predicate for the query.
     * @param root Root price input parameter.
     * @param query Criteria query parameter.
     * @param builder Criteria builder parameter.
     * @return Custom predicate for the query.
     */
    @Override
    public Predicate toPredicate
            (Root<Price> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        if (criteria.getOperation().equalsIgnoreCase(">=")) {
            return builder.greaterThanOrEqualTo(
                    root.get(criteria.getKey()), (LocalDateTime) criteria.getValue());
        }
        else if (criteria.getOperation().equalsIgnoreCase("<=")) {
            return builder.lessThanOrEqualTo(
                    root.get(criteria.getKey()), (LocalDateTime) criteria.getValue());
        }
        else if (criteria.getOperation().equalsIgnoreCase("=")) {
                return builder.equal(root.get(criteria.getKey()), criteria.getValue());
        }
        return null;
    }
}
