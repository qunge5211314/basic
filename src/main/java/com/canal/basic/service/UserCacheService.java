package com.canal.basic.service;

public interface UserCacheService {
    String generateAuthCode();

    void saveAuthCode(Long operationCode, String email, String authCode);

    void sendAuthCode(Long operationCode, String email, String authCode);

    void verifyAuthCode(Long operationCode, String email, String authCode);
}
