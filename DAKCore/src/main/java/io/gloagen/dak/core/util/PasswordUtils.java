package io.gloagen.dak.core.util;

import io.gloagen.dak.core.encrypt.HashedPassword;

public interface PasswordUtils {

    String generateSalt();

    HashedPassword generatePasswordHash(String plainPassword);

    boolean compare(HashedPassword hashedPassword, String plainPassword);

    boolean compare(String hashedPassword, String plainPassword);

}
