package com.canal.basic.service.impl;

import com.canal.basic.enumeration.UserOperation;
import com.canal.basic.exception.AuthCodeException;
import com.canal.basic.exception.AuthCodeExistException;
import com.canal.basic.service.UserCacheService;
import com.canal.basic.util.EmailClient;
import com.canal.basic.util.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserCacheServiceImpl implements UserCacheService {
    @Value("${redis.key.prefix.register}")
    private String registerKeyPrefix;

    @Value("${redis.key.prefix.updatePassword}")
    private String updatePasswordKeyPrefix;

    @Value("${basic.user.authentication.code.originString}")
    private String originString;

    @Value("${basic.user.authentication.code.length}")
    private Integer authCodeLength;

    @Value("${basic.user.authentication.code.duration}")
    private Long duration;

    @Value("${basic.user.email.subject.register}")
    private String registerSubject;

    @Value("${basic.user.email.subject.updatePassword}")
    private String updatePasswordSubject;

    @Value("${basic.response.message.authCodeExist}")
    private String authCodeExistMessage;

    @Autowired
    private RedisClient redisClient;

    @Autowired
    private EmailClient emailClient;


    @Override
    public String generateAuthCode() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < authCodeLength; ++i) {
            stringBuilder.append(originString.charAt(new Random().nextInt(originString.length())));
        }
        return stringBuilder.toString();
    }

    @Override
    public void saveAuthCode(Long operationCode, String email, String authCode) {
        String keyPrefix = getKeyPrefix(operationCode);
        String key = keyPrefix + email;
        if (redisClient.hasKey(key)) throw new AuthCodeExistException(authCodeExistMessage);
        redisClient.set(key, authCode, duration);
    }

    @Override
    public void sendAuthCode(Long operationCode, String email, String authCode) {
        String subject = getSubject(operationCode);
        emailClient.sendSimple(subject, authCode, email);
    }

    public String getSubject(Long operationCode) {
        String subject = "";
        if (operationCode.equals(UserOperation.REGISTER.getCode())) {
            subject = registerSubject;
        } else if (operationCode.equals(UserOperation.UPDATE_PASSWORD.getCode())) {
            subject = updatePasswordSubject;
        }
        return subject;
    }

    @Override
    public void verifyAuthCode(Long operationCode, String email, String authCode) {
        String keyPrefix = getKeyPrefix(operationCode);
        String key = keyPrefix + email;
        if (!redisClient.hasKey(key)) {
            throw new AuthCodeException("验证码错误或已失效");
        }
        String localAuthCode = (String) redisClient.get(key);
        if (!localAuthCode.equals(authCode)) throw new AuthCodeException("验证码错误或已失效");
    }

    public String getKeyPrefix(Long operationCode) {
        String keyPrefix = "";
        if (operationCode.equals(UserOperation.REGISTER.getCode())) {
            keyPrefix = registerKeyPrefix;
        } else if (operationCode.equals(UserOperation.UPDATE_PASSWORD.getCode())) {
            keyPrefix = updatePasswordKeyPrefix;
        }
        return keyPrefix;
    }
}
