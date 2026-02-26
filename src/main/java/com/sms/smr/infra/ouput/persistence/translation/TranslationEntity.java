package com.sms.smr.infra.ouput.persistence.translation;

import com.sms.smr.infra.ouput.persistence.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "translation")
@Entity
public class TranslationEntity extends BaseEntity {

    private String key;
    private String value;
    private String language;
    private String namespace;



    
}
