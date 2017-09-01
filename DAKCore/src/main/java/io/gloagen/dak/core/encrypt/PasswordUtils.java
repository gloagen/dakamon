package io.gloagen.dak.core.encrypt;

public interface PasswordUtils {

    String generateSalt();

    HashedPassword generatePasswordHash(String plainPassword);

    boolean compare(HashedPassword hashedPassword, String plainPassword);

}
