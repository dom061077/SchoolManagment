package com.sms.smr.infra.outputadapter.jparepository.queryrepository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.outputadapter.jpa.repository.QueryBaseJpaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QueryRepositoryBase<T, ID> implements QueryRepository<T, ID> {
    private final QueryBaseJpaRepository<T, ID> repository;
    private final BaseSpecificationBuilder<T> specificationBuilder;

    /**
     * Builds a dynamic JPA Specification based on a list of filters.
     * @param <T> The Entity type (LocalidadEntity, etc.)
     * @param filters List of property-operator-value requests
     * @param globalOperator "AND" or "OR"
     */    
    @Override
    public List<T> getAllAnd(int offset, int limit, List<QueryDto> queryFilters, List<QueryDto> sortingFilters) {
        Specification<T> spec = specificationBuilder.build(queryFilters);
        return repository.findAll(spec);
    }

    @Override
    public List<T> getAllAnd(Class<T> clazz, int offset, int limit, List<QueryDto> queryFilters,
            List<QueryDto> sortingFilters) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllAnd'");
    }

    @Override
    public List<T> getAllOr(Class<T> clazz, int offset, int limit, List<QueryDto> queryFilters) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllOr'");
    }

    @Override
    public long getCount(Class<T> clazz, List<QueryDto> queryFilters) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCount'");
    }

}
