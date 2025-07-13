package com.sms.smr.infra.outputadapter.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sms.smr.domain.MenuRole;
import com.sms.smr.infra.outputadapter.db.MenuRoleEntity;

@Mapper(
        componentModel = "spring"
)
public interface MenuRoleEntityMapper {

/*    private Long id;
    private String description;
    private String code;
    private String path; */


    /*    private String menuDescription;
    private String menuCode;
    private String menuPath; */

    @Mapping(source = "menu.description", target = "menuDescription")
    @Mapping(source = "menu.code", target = "menuCode")
    @Mapping(source = "menu.path", target = "menuPath")
    MenuRole toDomain(MenuRoleEntity menuRoleEntity);


    @Mapping(source = "menuDescription", target = "menu.description")
    @Mapping(source = "menuCode", target = "menu.code")
    @Mapping(source = "menuPath", target = "menu.path")
    @Mapping(source = "create", target = "create")
    @Mapping(source = "delete", target = "delete")
    @Mapping(source = "update", target = "update")
    MenuRoleEntity toEntity(MenuRole menuRole);

    @Mapping(source = "create", target = "create")
    @Mapping(source = "delete", target = "delete")
    @Mapping(source = "update", target = "update")
    MenuRoleEntity toDbo(MenuRole menuRole);

    default List<MenuRole> getMenuRoles(List<MenuRoleEntity> menuRolesEntities){
        return  menuRolesEntities.stream().map(menuRoleEntity->MenuRole.builder()
                    .menuDescription(menuRoleEntity.getMenu().getDescription())
                    .menuCode(menuRoleEntity.getMenu().getCode())
                    .menuPath(menuRoleEntity.getMenu().getPath())
                    .build()    
        ).collect(Collectors.toList());
    }
    
}


/*@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mapping(source = "department.name", target = "departmentName") // Flatten department
    @Mapping(source = "addresses", target = "addressList") // Convert List<Address> to List<String>
    PersonDTO toDTO(Person person);

    // Convert List<Address> to List<String> (only street names)
    default List<String> mapAddresses(List<Address> addresses) {
        return addresses.stream().map(Address::getStreet).collect(Collectors.toList());
    }
} */