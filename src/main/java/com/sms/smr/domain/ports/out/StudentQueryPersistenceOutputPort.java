package com.sms.smr.domain.ports.out;

import org.springframework.data.domain.Page;
import com.sms.smr.domain.model.Student;

public interface StudentQueryPersistenceOutputPort extends QueryPersistenceOutputPort<Student, Long> {
    Page<Student> searchStudents(Integer dni, String lastName, String firstName, int page, int size);
}
