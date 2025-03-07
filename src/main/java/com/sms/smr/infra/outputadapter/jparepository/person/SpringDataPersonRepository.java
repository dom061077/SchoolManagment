package com.sms.smr.infra.outputadapter.jparepository.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Component;

import com.sms.smr.infra.outputadapter.db.PersonEntity;


@Component
public interface SpringDataPersonRepository  extends JpaRepository<PersonEntity,Long>,
    RevisionRepository<PersonEntity,Long,Integer> {
    
}
