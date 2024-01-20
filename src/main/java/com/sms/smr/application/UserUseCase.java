package com.sms.smr.application;

import java.security.Principal;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.sms.smr.domain.ChangePasswordRequest;
import com.sms.smr.infra.outputadapter.db.UserEntity;
import com.sms.smr.infra.outputadapter.jparepository.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserUseCase {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository repository;
    public void changePassword(ChangePasswordRequest request, Principal connectedUser) {

        var user = (UserEntity) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        // check if the current password is correct
        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new IllegalStateException("Wrong password");
        }
        // check if the two new passwords are the same
        if (!request.getNewPassword().equals(request.getConfirmationPassword())) {
            throw new IllegalStateException("Password are not the same");
        }

        // update the password
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));

        // save the new password
        repository.save(user);
    }    
}
