package com.example.registerlogin.service.impl;

import com.example.registerlogin.entity.ConfirmationToken;
import com.example.registerlogin.service.ConfirmationTokenService;
import com.example.registerlogin.service.RegistrationService;
import com.example.registerlogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private ConfirmationTokenService tokenService;

    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public String confirmToken(String token) throws Exception {

        ConfirmationToken confirmationToken = tokenService.getByToken(token);
        if (confirmationToken == null) {
            throw new IllegalStateException("token not found");
        }

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("email already confirmed");
        }

        if (confirmationToken.getExpiredAt().isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }

        tokenService.setConfirmed(confirmationToken);
        userService.setActiveUser(confirmationToken.getUser().getEmail());


        return "confirmed";
    }
}
