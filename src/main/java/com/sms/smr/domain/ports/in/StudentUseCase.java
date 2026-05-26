package com.sms.smr.domain.ports.in;

import org.springframework.data.domain.Page;
import com.sms.smr.domain.model.Student;

public interface StudentUseCase extends BaseUseCase<Student, Long> {
    Page<Student> searchStudents(Integer dni, String lastName, String firstName, int page, int size);
}
