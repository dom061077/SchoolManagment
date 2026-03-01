package com.sms.smr.infra.ouput.persistence.academic;

import com.sms.smr.infra.ouput.persistence.BaseEntity;
import com.sms.smr.infra.ouput.persistence.school.GradeLevelEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name="materia")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Builder
public class SubjectEntity extends BaseEntity {
    private String name;
    @ManyToOne
    @JoinColumn(name="nivel_grado_id")
    private GradeLevelEntity gradeEntity;
    @ManyToOne
    @JoinColumn(name="docente_id")
    private TeacherEntity teacherEntity;
}
