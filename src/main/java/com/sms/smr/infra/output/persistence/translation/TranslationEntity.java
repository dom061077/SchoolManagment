package com.sms.smr.infra.output.persistence.translation;

import com.sms.smr.infra.output.persistence.BaseEntity;

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
