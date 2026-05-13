package com.sms.smr.infra.ouput.persistence.schoolexam;

import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/*
 SchoolExamReferenceMapper.java (The Helper)
This class is a Spring @Component whose sole purpose is to take an ID and return a JPA Entity.

It does this using entityManager.getReference(entityClass, id).

Why is this important? getReference does not hit the database with a SELECT query. Instead, it creates a lightweight, 
lazy-loaded "proxy" object that only contains the ID. 
This is the most efficient way to set a foreign key in JPA because it avoids unnecessary database reads

Haha, no, not at all! There is no AI or machine learning involved in MapStruct.

MapStruct is purely a deterministic, rule-based algorithm that runs inside the Java compiler. It is an "Annotation Processor" (just like Lombok).

When you run mvn compile, MapStruct's code executes before the final .class files are generated. 
It figures out which method to use through a very strict, mathematical process of elimination:

1 The Registry: MapStruct looks at your @Mapper(uses = SchoolExamReferenceMapper.class) and builds a simple list of every public method available to it.
2 The Problem: It sees @Mapping(target = "subject", source = "subjectId") and says: "Requirement: I need a method that takes a Long and returns a SubjectEntity."
3 The Search: It loops through its list of methods and checks the types one by one:
    Does toDomain work? No, it takes SchoolExamEntity and returns SchoolExam.
    Does detailToEntity work? No, it takes SchoolExamDetail and returns SchoolExamDetailEntity.
    Does resolve work? It takes (Long, Class<T>) and returns <T>.
4 The @TargetType Rule: MapStruct's developers hardcoded a specific rule for the @TargetType annotation. The rule says: "If you see this annotation, dynamically replace <T> with the target type I'm currently looking for (SubjectEntity), and pass SubjectEntity.class as the second argument."
5 The Final Check: MapStruct applies the rule. The signature becomes SubjectEntity resolve(Long, Class<SubjectEntity>).
Does the input Long match subjectId? Yes.
Does the return SubjectEntity match subject? Yes.
*/

@Component
public class SchoolExamReferenceMapper {

    @PersistenceContext
    private EntityManager entityManager;

    public <T> T resolve(Long id, @TargetType Class<T> entityClass) {
        if (id == null) {
            return null;
        }
        if (entityClass.equals(Long.class)) {
            return (T) id;
        }
        return entityManager.getReference(entityClass, id);
    }
}
