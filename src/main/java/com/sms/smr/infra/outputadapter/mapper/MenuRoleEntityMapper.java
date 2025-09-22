package com.sms.smr.infra.outputadapter.mapper;

import org.mapstruct.Mapper;

import com.sms.smr.domain.MenuRole;
import com.sms.smr.infra.outputadapter.db.MenuRoleEntity;

@Mapper(
        componentModel = "spring", uses = {MenuEntityMapper.class}
)
public interface MenuRoleEntityMapper extends EntityMapper<MenuRole, MenuRoleEntity> {

    
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