package com.sms.smr.infra.ouput.persistence.student;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import com.sms.smr.infra.ouput.persistence.localidad.LocalidadEntity;

@Mapper(componentModel = "spring")
public interface StudentReferenceMapper {
    @Named("localidadFromId")
    default LocalidadEntity mapLocalidadEntity(Long id) {
        if (id == null) return null;
        LocalidadEntity e = new LocalidadEntity();
        e.setId(id);
        return e;
    }
    @Named("parentescoFromId")    
    default ParentescoTutorEntity mapParentescoTutorEntity(Long id) {
        if (id == null) return null;
        ParentescoTutorEntity e = new ParentescoTutorEntity();
        e.setId(id);
        return e;
    }


}
