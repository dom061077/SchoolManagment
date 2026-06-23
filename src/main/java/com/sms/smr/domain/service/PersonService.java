package com.sms.smr.domain.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sms.smr.domain.model.PageResponse;
import com.sms.smr.domain.model.Person;
import com.sms.smr.domain.ports.in.PersonUseCase;
import com.sms.smr.domain.ports.out.CrudPersistenceOutputPort;
import com.sms.smr.domain.ports.out.PersonQueryPersistenceOutputPort;
import com.sms.smr.domain.exception.EntityNotFoundException;

import lombok.RequiredArgsConstructor;

@Service("personUseCase")
@RequiredArgsConstructor
public class PersonService implements PersonUseCase {

    private final CrudPersistenceOutputPort<Person, Long> crudOutputPort;
    private final PersonQueryPersistenceOutputPort personQueryPersistencePort;

    @Override
    public Person create(Person person) {
        return crudOutputPort.save(person);
    }

    @Override
    public Optional<Person> getById(Long id) {
        return crudOutputPort.getById(id);
    }

    @Override
    public PageResponse<Person> getAll(int offset, int limit, String queryFilters, String sortings, String loperator) {
        return personQueryPersistencePort.getAll(offset, limit, queryFilters, sortings, loperator);
    }

    @Override
    public Person update(Long id, Person person) {
        if (crudOutputPort.getById(id).isPresent()) {
            person.setId(id);
            return crudOutputPort.update(id, person).orElseThrow(() -> 
                new EntityNotFoundException("Error updating Person with id " + id)
            );
        }
        throw new EntityNotFoundException("Person with id " + id + " not found");
    }

    @Override
    public boolean delete(Long id) {
        if (crudOutputPort.getById(id).isPresent()) {
            return crudOutputPort.delete(id).isPresent();
        }
        throw new EntityNotFoundException("Person with id " + id + " not found");
    }
}
