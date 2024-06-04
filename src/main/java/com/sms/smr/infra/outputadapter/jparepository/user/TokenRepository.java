package com.sms.smr.infra.outputadapter.jparepository.user;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.sms.smr.infra.inputadapter.dto.query.QueryFilterDto;
import com.sms.smr.infra.outputadapter.db.PersonEntity;
import com.sms.smr.infra.outputadapter.db.TokenEntity;
import com.sms.smr.infra.outputadapter.db.UserEntity;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryRepository;
import com.sms.smr.infra.outputport.EntityRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component(value = "tokenRepository")
public class TokenRepository implements EntityRepository {

    private final SpringDataTokenRepository sDataTokenRepository;

    private final QueryRepository queryRepository;    

    @Override
    public <T> T save(T reg) {
        if(reg instanceof TokenEntity)
            return (T)sDataTokenRepository.save((TokenEntity)reg);
        else
            return null;
    }

    @Override
    public <T> T getById(Long id) {
        return (T)sDataTokenRepository.getReferenceById(id);
    }

    @Override
    public <T> List<T> getAll(int offset, int limit, List<QueryFilterDto> queryFilters, List<QueryFilterDto> sorts) {
        // TODO Auto-generated method stub
        return (List<T>) queryRepository.getAllAnd(TokenEntity.class, offset, limit, queryFilters, sorts);
    }


    public <T> List<T> findAllValidTokenByUser(Long id){
        return (List<T>)sDataTokenRepository.findAllValidTokenByUser(id);
    }

    public <T> Optional<TokenEntity> findByToken(String token){
        return (Optional<TokenEntity>) sDataTokenRepository.findByToken(token);
    }

    public void saveAll(java.util.List tokens){
        sDataTokenRepository.saveAll(tokens);
    }

    @Override
    public <T> T update(Long id, T reg) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
