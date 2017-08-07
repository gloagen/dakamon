package io.gloagen.dak.core.processor.user.account;

import io.gloagen.dak.core.exception.InvalidEmailAdressException;
import io.gloagen.persistence.dakamon.entity.user.EmailAddress;

public interface EmailAddressProcessor {

    EmailAddress createEmailAddress(String email) throws InvalidEmailAdressException;

    boolean isValidEmailAddress(String email);

    boolean exist(String email);
}
