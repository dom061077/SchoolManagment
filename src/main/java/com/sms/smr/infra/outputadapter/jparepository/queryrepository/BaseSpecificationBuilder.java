package com.sms.smr.infra.outputadapter.jparepository.queryrepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.From;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;


public class BaseSpecificationBuilder<T> {

    public Specification<T> build(List<FilterRequest> filters) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            for (FilterRequest filter : filters) {
                // 1. Separate path from operator (e.g., "departamento.id:eq")
                String[] parts = filter.getProperty().split(":");
                String pathStr = parts[0];
                String operator = parts.length > 1 ? parts[1] : "eq";

                // 2. Resolve path with Join reuse
                Path<?> path = getPath(root, pathStr);

                // 3. Create Predicate based on operator
                predicates.add(createPredicate(path, filter.getValue(), operator, cb));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }

    private Path<?> getPath(Root<T> root, String propertyPath) {
        String[] parts = propertyPath.split("\\.");
        Path<?> path = root;

        for (int i = 0; i < parts.length; i++) {
            if (i < parts.length - 1) {
                path = getOrCreateJoin((From<?, ?>) path, parts[i]);
            } else {
                path = path.get(parts[i]);
            }
        }
        return path;
    }

    private Join<?, ?> getOrCreateJoin(From<?, ?> from, String attribute) {
        return from.getJoins().stream()
                .filter(j -> j.getAttribute().getName().equals(attribute))
                .findFirst()
                .orElseGet(() -> from.join(attribute, JoinType.LEFT));
    }

    private Predicate createPredicate(Path<?> path, Object value, String op, CriteriaBuilder cb) {
        return switch (op) {
            case "eq" -> cb.equal(path, value);
            case "like" -> cb.like(cb.lower(path.as(String.class)), "%" + value.toString().toLowerCase() + "%");
            case "gt" -> cb.greaterThan((Expression<Comparable>) path, (Comparable) value);
            case "lt" -> cb.lessThan((Expression<Comparable>) path, (Comparable) value);
            default -> cb.equal(path, value);
        };
    }
}
