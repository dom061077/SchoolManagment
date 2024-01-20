package com.sms.smr.infra.outputadapter.mapper;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.sms.smr.domain.Token;
import com.sms.smr.infra.outputadapter.db.TokenEntity;
import com.sms.smr.infra.outputadapter.db.UserEntity;
import java.util.Optional;

@Mapper(
        componentModel = "spring" 
)
public interface TokenEntityMapper {
    
    @Mapping(target = "user.id",ignore=true)  
    Token toDomain(TokenEntity tokenEntity); 

    TokenEntity toDbo(Token token);

    List<Token> getTokens(List<TokenEntity> tokenEntities);    
    List<TokenEntity> getTokensEnt(List<Token> tokens);
    
    @AfterMapping
    default void setUser(@MappingTarget UserEntity user) {

        Optional.ofNullable(user.getTokens())
                .ifPresent(it -> it.forEach(item -> item.setUser(user)));


    }    
}
