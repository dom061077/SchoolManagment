package com.sms.smr.domain.ports.in;

import com.sms.smr.domain.model.PageResponse;
import com.sms.smr.domain.model.Student;

public interface StudentUseCase extends BaseUseCase<Student, Long> {
    PageResponse<Student> searchStudents(Integer dni, String lastName, String firstName, int page, int size);
}
