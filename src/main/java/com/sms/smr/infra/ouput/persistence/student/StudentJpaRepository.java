package com.sms.smr.infra.ouput.persistence.student;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/*
PA is a framework designed to eliminate boilerplate code. They created @Query as a convenient way for you to attach custom JPQL 
or native SQL strings directly to your repository interface methods.
If you were writing a query using strictly core JPA standards, you wouldn't use an interface annotation like @Query. 
Instead, you would use an EntityManager inside a Service/DAO class or use a @NamedQuery annotation directly on top of your StudentEntity class
 */

public interface StudentJpaRepository extends JpaRepository<StudentEntity, Long> , JpaSpecificationExecutor<StudentEntity>{
    //JPQL (Java Persistence Query Language)   
    @Query("SELECT s FROM StudentEntity s WHERE " +
           "(:dni IS NULL OR s.dni = :dni) AND " +
           "((:lastName IS NULL OR LOWER(s.lastName) LIKE LOWER(CONCAT('%', :lastName, '%'))) AND " +
           "(:firstName IS NULL OR LOWER(s.firstName) LIKE LOWER(CONCAT('%', :firstName, '%'))))"
           +" AND s.deleted = false"
           +" ORDER BY s.lastName, s.firstName"
           )
    Page<StudentEntity> searchStudents(
            @Param("dni") Integer dni, 
            @Param("lastName") String lastName, 
            @Param("firstName") String firstName,
            Pageable pageable);
}
