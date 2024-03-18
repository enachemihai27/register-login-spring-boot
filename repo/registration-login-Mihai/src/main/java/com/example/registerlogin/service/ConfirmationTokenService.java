package com.example.registerlogin.service;

import com.example.registerlogin.entity.ConfirmationToken;

import java.time.LocalDateTime;

public interface ConfirmationTokenService {
    public void saveToken(ConfirmationToken token) throws Exception;

    public ConfirmationToken getByToken(String token) throws Exception;

    public void setConfirmed(ConfirmationToken token) throws Exception;
}
