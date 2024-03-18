package com.example.registerlogin.service.impl;

import com.example.registerlogin.entity.ConfirmationToken;
import com.example.registerlogin.repository.ConfirmationTokenRepository;
import com.example.registerlogin.service.ConfirmationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ConfirmationTokenServiceImpl implements ConfirmationTokenService {

    @Autowired
    private ConfirmationTokenRepository tokenRepository;

    public void saveToken(ConfirmationToken token) throws Exception{
        tokenRepository.save(token);
    }


    @Override
    public ConfirmationToken getByToken(String token) throws Exception {
        return tokenRepository.findByToken(token);
    }

    @Override
    public void setConfirmed(ConfirmationToken token) throws Exception {
        token.setConfirmedAt(LocalDateTime.now());
    }
}
