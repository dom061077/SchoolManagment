package com.sms.smr.infra.inputadapter.dto.translation;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranslationDto {
    private Long id; 
    @NotBlank
    private String key; 
    private String value; 
    private String language;
    private String namespace;
}
