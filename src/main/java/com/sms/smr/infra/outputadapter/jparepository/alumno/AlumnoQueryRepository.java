package com.sms.smr.infra.outputadapter.jparepository.alumno;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoQueryRepository {
    // Define custom query methods if needed
    public <T> List<T> getAll(int offe,int limit);
}