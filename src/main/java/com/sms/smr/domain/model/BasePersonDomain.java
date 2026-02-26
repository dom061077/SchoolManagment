package com.sms.smr.domain.model;

import java.time.LocalDate;

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


public class BasePersonDomain extends BaseDomain {
    //@NotBlank(message = "Last name is required")
    private String lastName;
    //@NotBlank(message = "First name is required")
    private String firstName;
    private int dni;
    private LocalDate birthDate;
    private String address;    
}
