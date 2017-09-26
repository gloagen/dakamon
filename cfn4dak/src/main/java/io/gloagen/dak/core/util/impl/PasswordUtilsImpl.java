package io.gloagen.dak.core.util.impl;

import io.gloagen.dak.core.encrypt.HashedPassword;
import io.gloagen.dak.core.util.PasswordUtils;
import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtilsImpl implements PasswordUtils {

    static final int NUM_BYTES_LENGTH = 13;

    @Override
    public String generateSalt() {
        return BCrypt.gensalt(NUM_BYTES_LENGTH);
    }

    @Override
    public HashedPassword generatePasswordHash(String plainPassword) {

        String salt = generateSalt();
        String hash = BCrypt.hashpw(plainPassword, salt);

        HashedPassword hashedPassword = new HashedPassword();
        hashedPassword.setHash(hash);
        hashedPassword.setSalt(salt);

        return hashedPassword;
    }

    @Override
    public boolean compare(HashedPassword hashedPassword, String plainPassword) {
        return compare(hashedPassword.getHash(), plainPassword);
    }

    @Override
    public boolean compare(String hashedPassword, String plainPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }

}
