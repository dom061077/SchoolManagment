package com.sms.smr.infra.outputadapter.listener;

import org.hibernate.envers.RevisionListener;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import com.sms.smr.infra.outputadapter.db.CustomRevisionEntity;

public class CustomRevisionListener implements RevisionListener {
    @Override
    public void newRevision(Object revisionEntity) {
        CustomRevisionEntity revEntity = (CustomRevisionEntity) revisionEntity;
        
        // Retrieve the authenticated user from Keycloak
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication instanceof JwtAuthenticationToken jwtToken) {
            revEntity.setUsername(jwtToken.getToken().getClaimAsString("preferred_username"));
        } else {
            revEntity.setUsername("Unknown");
        }
    }
}
