package com.sms.smr.infra.outputadapter.db.school;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="division")
public class SectionEntity {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @NotBlank
    private String name;
    @ManyToMany(mappedBy = "sections") //refereces "sections" in GradeLevelEntity
    private java.util.Set<GradeLevelEntity> gradeLevels;
}
