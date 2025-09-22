package com.sms.smr.infra.outputadapter.mapper;

import org.mapstruct.Mapper;

import com.sms.smr.domain.Menu;
import com.sms.smr.infra.outputadapter.db.MenuEntity;

@Mapper(componentModel = "spring")
public interface MenuEntityMapper extends EntityMapper<Menu, MenuEntity> {

}
