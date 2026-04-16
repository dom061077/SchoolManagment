package com.sms.smr.infra.ouput.persistence.student;

import org.mapstruct.Mapper;

import com.sms.smr.infra.ouput.persistence.localidad.LocalidadEntity;

@Mapper(componentModel = "spring")
public interface StudentReferenceMapper {
    default LocalidadEntity mapLocalidad(Long id) {
        if (id == null) return null;
        LocalidadEntity e = new LocalidadEntity();
        e.setId(id);
        return e;
    }
    default ParentescoTutorEntity mapParentescoTutor(Long id) {
        if (id == null) return null;
        ParentescoTutorEntity e = new ParentescoTutorEntity();
        e.setId(id);
        return e;
    }
}
