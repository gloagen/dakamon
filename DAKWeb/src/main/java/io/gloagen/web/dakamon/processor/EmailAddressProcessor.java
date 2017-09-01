package io.gloagen.web.dakamon.processor;

import io.gloagen.dak.core.exception.InvalidEmailAdressException;
import io.gloagen.persistence.dakamon.entity.user.EmailAddress;
import io.gloagen.persistence.dakamon.entity.user.UserAccount;

public interface EmailAddressProcessor {

    EmailAddress createEmailAddress(String email, UserAccount userAccount) throws InvalidEmailAdressException;

    boolean isValidEmailAddress(String email);

    boolean exist(String email);
}
