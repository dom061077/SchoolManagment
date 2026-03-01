package com.sms.smr.infra.ouput.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sms.smr.domain.ports.out.QueryPersistenceOutputPort;
import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.utils.Utils;






public abstract class QueryRepositoryBase<T, ID,E , R extends JpaRepository<E, ID> & JpaSpecificationExecutor<E>> implements QueryPersistenceOutputPort<T, ID> {
    private final R repository;
    private final BaseSpecificationBuilder<E> specificationBuilder;
    private final EntityMapper<T, E> mapper;


    public QueryRepositoryBase(R repository, BaseSpecificationBuilder<E> specificationBuilder, EntityMapper<T, E> mapper) {
        this.repository = repository;
        this.specificationBuilder = specificationBuilder;
        this.mapper = mapper;

    }





    @Override
    public Page<T> getAll(int offset, int limit, String queryFilters, String sortingFilters, String globalOperator) {
        List<QueryDto> qDtoFilters = Utils.stringToQueryFilterDto(queryFilters);
        List<QueryDto> qDtoSorts = Utils.stringToQueryFilterDto(globalOperator);

        Specification<E> spec = specificationBuilder.build(qDtoFilters, globalOperator);
        PageRequest pageRequest = PageRequest.of(offset / limit, limit);
        Sort sort = Sort.unsorted();
        if (sortingFilters != null && !sortingFilters.isEmpty()) {
            for (QueryDto sortDto : qDtoSorts) {
                Sort.Direction direction = sortDto.getValue().equalsIgnoreCase("DESC") ? Sort.Direction.DESC : Sort.Direction.ASC;
                sort = sort.and(Sort.by(direction, sortDto.getProperty()));
            }
            
        }
        pageRequest = PageRequest.of(offset / limit, limit, sort);
        Page<E> page = repository.findAll(spec, pageRequest);
        
        return page.map(entity->{
            return mapper.toDomain(entity, new CycleAvoidingMappingContext());
        });
    }

}
