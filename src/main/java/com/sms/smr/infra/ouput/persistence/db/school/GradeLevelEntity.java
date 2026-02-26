package com.sms.smr.infra.ouput.persistence.db.school;
/*
Este es el curso
 */

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="nivel_grado")
public class GradeLevelEntity {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private int gradeNumber;

    @ManyToMany
    @JoinTable(
        name = "curso_division",
        joinColumns = @JoinColumn(name = "curso_id"),
        inverseJoinColumns = @JoinColumn(name = "division_id")
    )
    private java.util.Set<SectionEntity> sections;

    @ManyToMany
    @JoinTable(
        name = "curso_turno",
        joinColumns = @JoinColumn(name = "curso_id"),
        inverseJoinColumns = @JoinColumn(name = "turno_id")
    )
    private java.util.Set<ShiftEntity> shifts;
}
