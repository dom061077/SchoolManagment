package com.sms.smr.infra.output.persistence.db;

import com.sms.smr.domain.model.TokenType;
import com.sms.smr.infra.output.persistence.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
//@Entity
@Getter
@Setter 
@NoArgsConstructor
@AllArgsConstructor
//@Table(name="token")
public class TokenEntity extends BaseEntity {


  @Id
  @GeneratedValue
  public Long id;

  @Column(unique = true)
  public String token;

  @Enumerated(EnumType.STRING)
  public TokenType tokenType = TokenType.BEARER;

  public boolean revoked;

  public boolean expired;

  //@ManyToOne(fetch = FetchType.LAZY)
  //@JoinColumn(name = "user_id")
  public UserEntity user;
    
}
