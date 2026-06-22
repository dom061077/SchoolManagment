package com.sms.smr.infra.outputadapter.mapper;

import org.mapstruct.Mapper;

import com.sms.smr.domain.model.Menu;
import com.sms.smr.infra.ouput.persistence.EntityMapper;
import com.sms.smr.infra.ouput.persistence.db.MenuEntity;

@Mapper(componentModel = "spring")
public interface MenuEntityMapper extends EntityMapper<Menu, MenuEntity> {

}
