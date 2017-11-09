package io.gloagen.dak.core.util.impl;

import io.gloagen.dak.core.util.TokenGenerator;

import java.security.SecureRandom;
import java.util.Base64;

public class TokenGeneratorImpl implements TokenGenerator {

    public static final int TOKEN_BYTE_LENGTH = 32;

    @Override
    public String generateToken() {

        SecureRandom secureRandom = new SecureRandom();
        byte[] bytes = new byte[TOKEN_BYTE_LENGTH];
        secureRandom.nextBytes(bytes);

        return Base64.getEncoder().withoutPadding().encodeToString(bytes);
    }

}
