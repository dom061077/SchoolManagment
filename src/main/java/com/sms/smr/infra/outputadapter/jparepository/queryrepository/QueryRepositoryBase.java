package com.sms.smr.infra.outputadapter.jparepository.queryrepository;

import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;





public abstract class QueryRepositoryBase<T, ID, R extends JpaRepository<T, ID> & JpaSpecificationExecutor<T>> implements QueryRepository<T, ID> {
    private final R repository;
    private final BaseSpecificationBuilder<T> specificationBuilder;

    public QueryRepositoryBase(R repository, BaseSpecificationBuilder<T> specificationBuilder) {
        this.repository = repository;
        this.specificationBuilder = specificationBuilder;
    }


    /**
     * Builds a dynamic JPA Specification based on a list of filters.
     * @param <T> The Entity type (LocalidadEntity, etc.)
     * @param filters List of property-operator-value requests
     * @param globalOperator "AND" or "OR"
     */    
    @Override
    public List<T> getAllAnd(int offset, int limit, List<QueryDto> queryFilters, List<QueryDto> sortingFilters) {
        Specification<T> spec = specificationBuilder.build(queryFilters, AND_OPERATOR);
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
        Specification<T> spec = specificationBuilder.build(queryFilters, AND_OPERATOR);
        return repository.count(spec);
    }

    @Override
    public Page<T> getAll(int offset, int limit, List<QueryDto> queryFilters, List<QueryDto> sortingFilters, String globalOperator) {
        Specification<T> spec = specificationBuilder.build(queryFilters, globalOperator);
        PageRequest pageRequest = PageRequest.of(offset / limit, limit);
        Sort sort = Sort.unsorted();
        if (sortingFilters != null && !sortingFilters.isEmpty()) {
            for (QueryDto sortDto : sortingFilters) {
                Sort.Direction direction = sortDto.getValue().equalsIgnoreCase("DESC") ? Sort.Direction.DESC : Sort.Direction.ASC;
                sort = sort.and(Sort.by(direction, sortDto.getProperty()));
            }
            
        }
        pageRequest = PageRequest.of(offset / limit, limit, sort);
        return repository.findAll(spec, pageRequest);
    }

}
