package com.sms.smr.config;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import static java.util.stream.Collectors.toSet;



public class KeycloakJwtAuthenticationConverter implements Converter<Jwt, AbstractAuthenticationToken>{
    @Override
    public AbstractAuthenticationToken convert(@NonNull Jwt source) {
        return new JwtAuthenticationToken(
                source,
                Stream.concat(
                                new JwtGrantedAuthoritiesConverter().convert(source).stream(),
                                extractResourceRoles(source).stream())
                        .collect(toSet()));
    }

    private Collection<? extends GrantedAuthority> extractResourceRoles(Jwt jwt) {
         Collection<GrantedAuthority> realmAuthorities = ((List<String>) ((Map<String, Object>) jwt.getClaims()
            .get("realm_access")).get("roles"))
            .stream()
            .map(role -> new SimpleGrantedAuthority("ROLE_REALM_" + role))
            .collect(Collectors.toList());

        // Extract resource roles
        Collection<GrantedAuthority> resourceAuthorities = ((Map<String, Object>) jwt.getClaims()
            .get("resource_access"))
            .entrySet()
            .stream()
            .flatMap(entry -> ((List<String>) ((Map<String, Object>) entry.getValue()).get("roles"))
                .stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_RESOURCE_" + entry.getKey() + "_" + role)))
            .collect(Collectors.toList());

        return Stream.concat(realmAuthorities.stream(), resourceAuthorities.stream())
                .collect(Collectors.toSet());
    }
}
