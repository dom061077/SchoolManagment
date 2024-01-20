package com.sms.smr.infra.outputadapter.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.sms.smr.domain.User;
import com.sms.smr.infra.outputadapter.db.UserEntity;

@Mapper(
    componentModel = "spring"
)
public interface UserEntityMapper {
    User toDomain(UserEntity userEntity);
    UserEntity toDbo(User user);
    List<User> getUsers(List<UserEntity> userEntities);
}
