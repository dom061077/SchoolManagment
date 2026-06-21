package com.sms.smr.domain.ports.out;

import com.sms.smr.domain.model.PageResponse;
import com.sms.smr.domain.model.Student;

public interface StudentQueryPersistenceOutputPort extends QueryPersistenceOutputPort<Student, Long> {
    PageResponse<Student> searchStudents(Integer dni, String lastName, String firstName, int page, int size);
}
