package com.sms.smr.infra.ouput.persistence.academic.teacher;

import com.sms.smr.infra.ouput.persistence.BasePersonEntity;
import com.sms.smr.infra.ouput.persistence.academic.SubjectEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "docente")
@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherEntity extends BasePersonEntity {
    private String userName;

    @OneToMany
    @JoinColumn(name = "docente_id")
    private java.util.Set<SubjectEntity> subjects;
}
