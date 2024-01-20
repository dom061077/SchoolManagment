package com.sms.smr.infra.outputadapter.jparepository.user;

import com.sms.smr.infra.outputadapter.db.TokenEntity;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SpringDataTokenRepository extends JpaRepository<TokenEntity,Long>{ 
 
  @Query(value = """
      select t from TokenEntity t inner join UserEntity u\s
      on t.user.id = u.id\s
      where u.id = :id and (t.expired = false or t.revoked = false)\s
      """)
  List<TokenEntity> findAllValidTokenByUser(Long id);

  Optional<TokenEntity> findByToken(String token);    
    
}
