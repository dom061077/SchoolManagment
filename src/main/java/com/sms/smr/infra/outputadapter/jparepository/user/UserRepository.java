package com.sms.smr.infra.outputadapter.jparepository.user;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.sms.smr.domain.ChangePasswordRequest;
import com.sms.smr.infra.inputadapter.dto.query.QueryFilterDto;
import com.sms.smr.infra.outputadapter.db.PersonEntity;
import com.sms.smr.infra.outputadapter.db.UserEntity;
import com.sms.smr.infra.outputadapter.jparepository.person.SpringDataPersonRepository;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryRepository;
import com.sms.smr.infra.outputport.EntityRepository;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Component(value = "userRepository")
public class UserRepository implements EntityRepository{

    private final SpringDataUserRepository sDataUserRepository;

    private final QueryRepository queryRepository;


    @Override
    public <T> T save(T reg) {
        if(reg instanceof UserEntity)
            return (T)sDataUserRepository.save((UserEntity)reg);
        else
            return null;
    }

    @Override
    public <T> T getById(Long id) {
        return (T)sDataUserRepository.findById(id).orElseThrow();
    }

    @Override
    public <T> List<T> getAll(int offset, int limit, List<QueryFilterDto> queryFilters,List<QueryFilterDto> sorts) {
        // TODO Auto-generated method stub
        return (List<T>) queryRepository.getAllAnd(UserEntity.class, offset, limit, queryFilters, sorts);
    }

    public <T> Optional<T> findByEmail(String email){
        return (Optional<T>) sDataUserRepository.findByEmail(email);
    }

   @Override
    public <T> T update(Long id,T reg) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

}
