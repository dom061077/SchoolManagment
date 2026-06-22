package com.sms.smr.infra.ouput.persistence.school;

import org.hibernate.annotations.ManyToAny;

import com.sms.smr.infra.ouput.persistence.gradelevel.GradeLevelEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "turno")
public class ShiftEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "shifts") // references "shifts" in GradeLevelEntity
    private java.util.Set<GradeLevelEntity> gradeLevels;
}
