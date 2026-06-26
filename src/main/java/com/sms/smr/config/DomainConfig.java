package com.sms.smr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sms.smr.domain.model.Departamento;
import com.sms.smr.domain.model.GradeLevel;
import com.sms.smr.domain.model.Localidad;
import com.sms.smr.domain.model.Person;
import com.sms.smr.domain.model.Provincia;
import com.sms.smr.domain.model.School;
import com.sms.smr.domain.model.Section;
import com.sms.smr.domain.model.Shift;
import com.sms.smr.domain.model.Student;
import com.sms.smr.domain.model.StudentRegistration;
import com.sms.smr.domain.model.Translation;
import com.sms.smr.domain.model.academic.AcademicYear;
import com.sms.smr.domain.model.academic.SchoolExam;
import com.sms.smr.domain.ports.in.BaseQueryUseCase;
import com.sms.smr.domain.ports.in.BaseUseCase;
import com.sms.smr.domain.ports.in.StudentUseCase;
import com.sms.smr.domain.ports.out.CrudPersistenceOutputPort;
import com.sms.smr.domain.ports.out.PersonQueryPersistenceOutputPort;
import com.sms.smr.domain.ports.out.QueryPersistenceOutputPort;
import com.sms.smr.domain.ports.out.SchoolQueryPersistenceOutputPort;
import com.sms.smr.domain.ports.out.StudentQueryPersistenceOutputPort;
import com.sms.smr.domain.service.DepartamentoService;
import com.sms.smr.domain.service.EnumValuesService;
import com.sms.smr.domain.service.LocalidadService;
import com.sms.smr.domain.service.PersonService;
import com.sms.smr.domain.service.ProvinciaService;
import com.sms.smr.domain.service.StudentRegistrationService;
import com.sms.smr.domain.service.StudentService;
import com.sms.smr.domain.service.TranslationService;
import com.sms.smr.domain.service.academic.AcademicYearService;
import com.sms.smr.domain.service.academic.SchoolExamService;
import com.sms.smr.domain.service.school.GradeLevelService;
import com.sms.smr.domain.service.school.SchoolService;
import com.sms.smr.domain.service.school.SectionService;
import com.sms.smr.domain.service.school.ShiftService;
import com.sms.smr.domain.ports.in.EnumValuesUseCase;

@Configuration
public class DomainConfig {

    @Bean
    public EnumValuesUseCase enumValuesUseCase() {
        return new EnumValuesService();
    }

    @Bean
    public BaseUseCase<AcademicYear, Long> academicYearUseCase(
            CrudPersistenceOutputPort<AcademicYear, Long> crudOutputPort,
            QueryPersistenceOutputPort<AcademicYear, Long> queryOutputPort) {
        return new AcademicYearService(crudOutputPort, queryOutputPort);
    }

    @Bean
    public BaseUseCase<Localidad, Long> localidadUseCase(
            QueryPersistenceOutputPort<Localidad, Long> queryOutputPort) {
        return new LocalidadService(queryOutputPort);
    }

    @Bean("personUseCase")
    public BaseUseCase<Person, Long> personUseCase(
            CrudPersistenceOutputPort<Person, Long> crudOutputPort,
            PersonQueryPersistenceOutputPort personQueryPersistencePort) {
        return new PersonService(crudOutputPort, personQueryPersistencePort);
    }

    @Bean
    public BaseUseCase<Translation, Long> translationUseCase(
            CrudPersistenceOutputPort<Translation, Long> crudPersistenceOutputPort,
            QueryPersistenceOutputPort<Translation, Long> queryPersistenceOutputPort) {
        return new TranslationService(crudPersistenceOutputPort, queryPersistenceOutputPort);
    }

    @Bean
    public BaseUseCase<GradeLevel, Long> gradeLevelUseCase(
            CrudPersistenceOutputPort<GradeLevel, Long> crudOutputPort,
            QueryPersistenceOutputPort<GradeLevel, Long> queryOutputPort) {
        return new GradeLevelService(crudOutputPort, queryOutputPort);
    }

    @Bean
    public BaseUseCase<School, Long> schoolUseCase(
            SchoolQueryPersistenceOutputPort queryOutputPort,
            CrudPersistenceOutputPort<School, Long> crudOutputPort) {
        return new SchoolService(queryOutputPort, crudOutputPort);
    }

    @Bean
    public BaseUseCase<Section, Long> sectionUseCase(
            CrudPersistenceOutputPort<Section, Long> crudOutputPort,
            QueryPersistenceOutputPort<Section, Long> queryOutputPort) {
        return new SectionService(crudOutputPort, queryOutputPort);
    }

    @Bean
    public BaseUseCase<Shift, Long> shiftUseCase(
            QueryPersistenceOutputPort<Shift, Long> queryOutputPort) {
        return new ShiftService(queryOutputPort);
    }

    @Bean
    public StudentUseCase studentUseCase(
            CrudPersistenceOutputPort<Student, Long> crudOutputPort,
            StudentQueryPersistenceOutputPort studentQueryJpaRepository) {
        return new StudentService(crudOutputPort, studentQueryJpaRepository);
    }

    @Bean
    public BaseUseCase<StudentRegistration, Long> studentRegistrationUseCase(
            CrudPersistenceOutputPort<StudentRegistration, Long> crudOutputPort,
            QueryPersistenceOutputPort<StudentRegistration, Long> queryRepository) {
        return new StudentRegistrationService(crudOutputPort, queryRepository);
    }

    @Bean
    public BaseUseCase<Provincia, Long> provinciaUseCase(
            QueryPersistenceOutputPort<Provincia, Long> queryOutputPort) {
        return new ProvinciaService(queryOutputPort);
    }

    @Bean
    public BaseQueryUseCase<Departamento, Long> departamentoUseCase(
            QueryPersistenceOutputPort<Departamento, Long> queryPersistenceOutputPort) {
        return new DepartamentoService(queryPersistenceOutputPort);
    }

    @Bean
    public BaseUseCase<SchoolExam, Long> schoolExamUseCase(
            CrudPersistenceOutputPort<SchoolExam, Long> crudOutputPort,
            QueryPersistenceOutputPort<SchoolExam, Long> queryRepository) {
        return new SchoolExamService(crudOutputPort, queryRepository);
    }
}
