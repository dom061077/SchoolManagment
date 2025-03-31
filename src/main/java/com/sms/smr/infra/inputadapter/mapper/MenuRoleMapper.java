package com.sms.smr.infra.inputadapter.mapper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;

import com.sms.smr.domain.MenuRole;
import com.sms.smr.infra.inputadapter.dto.menurole.MenuRoleDto;

@Mapper(
    componentModel = "spring"
)
public interface MenuRoleMapper {
    
    default List<MenuRoleDto> getMenuRoleDtos(List<MenuRole> menuRoles){
        Set<String> menuCodeExists = new HashSet<>();

        return menuRoles.stream().filter(menuRole -> menuCodeExists.add(menuRole.getMenuCode()))
                .map(menuRole->{ MenuRoleDto menuRoleDto = MenuRoleDto.builder()
                                .menuDescription(menuRole.getMenuDescription())
                                .menuCode(menuRole.getMenuCode())
                                .menuPath(menuRole.getMenuPath()).build();
                                return menuRoleDto;
                }
                ).collect(Collectors.toList());
    }
}
