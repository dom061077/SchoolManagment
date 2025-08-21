package com.sms.smr.infra.outputadapter.db;



import java.time.LocalDate;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BasePersonEntity extends BaseEntity {
    @NotBlank(message = "Last name is required")
    private String lastName;
    @NotBlank(message = "First name is required")
    private String firstName;
    private int dni;
    private LocalDate birthDate;
    private String address;

}
