package com.sms.smr.infra.outputadapter.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.sms.smr.domain.Menu;
import com.sms.smr.infra.outputadapter.db.MenuEntity;

@Mapper(
        componentModel = "spring"
)
public interface MenuEntityMapper {
    Menu toDomain(MenuEntity menuEntity);

    MenuEntity toEntity(Menu menu);

    List <Menu> getMenues(List<MenuEntity> menuEntities);
}
