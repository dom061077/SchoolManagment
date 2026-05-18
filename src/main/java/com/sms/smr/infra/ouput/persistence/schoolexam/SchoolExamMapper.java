package com.sms.smr.infra.ouput.persistence.schoolexam;

import org.mapstruct.AfterMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.sms.smr.domain.model.academic.SchoolExam;
import com.sms.smr.domain.model.academic.SchoolExamDetail;
import com.sms.smr.infra.ouput.persistence.CycleAvoidingMappingContext;
import com.sms.smr.infra.ouput.persistence.EntityMapper;
import com.sms.smr.infra.ouput.persistence.academic.SchoolExamDetailEntity;
import com.sms.smr.infra.ouput.persistence.academic.SchoolExamEntity;

/*
The SchoolExamDetailEntity has a @ManyToOne relationship with SchoolExamEntity where schoolExam is annotated with @NotNull. 
When mapping the incoming domain object SchoolExam to SchoolExamEntity using SchoolExamMapper,
 MapStruct converts the list of details properly but it wasn't successfully setting the parent reference (schoolExam) on the newly created detail entities.

Even though you had an @AfterMapping method linkDetails defined in SchoolExamMapper to accomplish exactly this, 
MapStruct was ignoring it during the toEntity method generation. 
This happens because MapStruct uses the Builder pattern by default for classes annotated with @SuperBuilder. Since @AfterMapping expects a built SchoolExamEntity object (not a builder), MapStruct wasn't able to call it before returning builder.build().

*/

@Mapper(componentModel = "spring", uses = SchoolExamReferenceMapper.class, builder = @org.mapstruct.Builder(disableBuilder = true))
public interface SchoolExamMapper extends EntityMapper<SchoolExam, SchoolExamEntity> {

    @Override
    @Mapping(target = "tipoExamenId", source = "tipoExamen.id")
    @Mapping(target = "tipoExamenName", source = "tipoExamen.name")
    @Mapping(target = "academicPeriodId", source = "academicPeriod.id")
    @Mapping(target = "subjectId", source = "subject.id")
    @Mapping(target = "subjectName", source = "subject.name")
    @Mapping(target = "teacherId", source = "teacher.id")
    SchoolExam toDomain(SchoolExamEntity entity, @Context CycleAvoidingMappingContext context);

    @Override
    @Mapping(target = "tipoExamen", source = "tipoExamenId")
    @Mapping(target = "academicPeriod", source = "academicPeriodId")
    @Mapping(target = "subject", source = "subjectId")
    @Mapping(target = "teacher", source = "teacherId")
    SchoolExamEntity toEntity(SchoolExam domain, @Context CycleAvoidingMappingContext context);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tipoExamen", source = "tipoExamenId")
    @Mapping(target = "academicPeriod", source = "academicPeriodId")
    @Mapping(target = "subject", source = "subjectId")
    @Mapping(target = "teacher", source = "teacherId")
    void updateEntityFromDomain(SchoolExam source, @MappingTarget SchoolExamEntity target,
            @Context CycleAvoidingMappingContext context);

    @Mapping(target = "schoolExamId", source = "schoolExam.id")
    @Mapping(target = "academicPeriodId", source = "academicPeriod.id")
    @Mapping(target = "studentRegistrationId", source = "studentRegistration.id")
    SchoolExamDetail detailToDomain(SchoolExamDetailEntity entity, @Context CycleAvoidingMappingContext context);

    @Mapping(target = "schoolExam", source = "schoolExamId")
    @Mapping(target = "academicPeriod", source = "academicPeriodId")
    @Mapping(target = "studentRegistration", source = "studentRegistrationId")
    SchoolExamDetailEntity detailToEntity(SchoolExamDetail domain, @Context CycleAvoidingMappingContext context);

    @AfterMapping
    default void linkDetails(@MappingTarget SchoolExamEntity entity) {
        if (entity.getDetails() != null) {
            for (SchoolExamDetailEntity detail : entity.getDetails()) {
                detail.setSchoolExam(entity);
            }
        }
    }
}
