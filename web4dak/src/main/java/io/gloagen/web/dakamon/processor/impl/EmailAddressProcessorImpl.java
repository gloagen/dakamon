package io.gloagen.web.dakamon.processor.impl;

import io.gloagen.dak.core.exception.InvalidEmailAdressException;
import io.gloagen.persistence.dakamon.accesslayer.EmailService;
import io.gloagen.persistence.dakamon.entity.user.EmailAddress;
import io.gloagen.persistence.dakamon.entity.user.UserAccount;
import io.gloagen.web.dakamon.processor.EmailAddressProcessor;
import org.apache.commons.validator.routines.EmailValidator;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Date;

@Transactional
public class EmailAddressProcessorImpl implements EmailAddressProcessor {

    @Inject EmailService emailService;

    public EmailAddress createEmailAddress(String email, UserAccount userAccount) throws InvalidEmailAdressException {
        if (isValidEmailAddress(email)) {

            EmailAddress emailAddress = new EmailAddress();
            emailAddress.setCreated(new Date());
            emailAddress.setEmail(email.toLowerCase());
            emailAddress.setValidated(false);
            emailAddress.setUserAccount(userAccount);

            emailService.save(emailAddress);

            return emailAddress;
        }
        throw new InvalidEmailAdressException(String.format("The email " + email + " supplied is invalid", email));
    }

    public boolean isValidEmailAddress(String email) throws InvalidEmailAdressException {
        if (!EmailValidator.getInstance().isValid(email)) {
            throw new InvalidEmailAdressException(String.format("Email address %s is invalid", email));
        }

        return true;
    }

    public boolean exist(String email) {
        return emailService.find(email) != null;
    }
}
