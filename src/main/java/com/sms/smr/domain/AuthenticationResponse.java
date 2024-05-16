package com.sms.smr.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
  private Long id;
  @JsonProperty("first_name")
  private String firstname;
  @JsonProperty("last_name")
  private String lastname;
  @JsonProperty("access_token")
  private String accessToken;
  @JsonProperty("refresh_token")
  private String refreshToken;
  
  private Role role;
  private List<String> authorities;//puede que esta propiedad no tenga uso
  @JsonProperty("menu_list")
  private List<String> menuList;
}

