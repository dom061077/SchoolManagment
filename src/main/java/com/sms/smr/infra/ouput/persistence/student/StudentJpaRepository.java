package com.sms.smr.infra.ouput.persistence.student;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentJpaRepository extends JpaRepository<StudentEntity, Long> , JpaSpecificationExecutor<StudentEntity>{

    @Query("SELECT s FROM StudentEntity s WHERE " +
           "(:dni IS NULL OR s.dni = :dni) AND " +
           "(:lastName IS NULL OR LOWER(s.lastName) LIKE LOWER(CONCAT('%', :lastName, '%'))) AND " +
           "(:firstName IS NULL OR LOWER(s.firstName) LIKE LOWER(CONCAT('%', :firstName, '%')))")
    Page<StudentEntity> searchStudents(
            @Param("dni") Integer dni, 
            @Param("lastName") String lastName, 
            @Param("firstName") String firstName,
            Pageable pageable);
}
