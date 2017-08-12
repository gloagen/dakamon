package io.gloagen.web.dakamon.processor.user.account.impl;

import io.gloagen.dak.core.exception.InvalidEmailAdressException;
import io.gloagen.persistence.dakamon.accesslayer.object.EmailService;
import io.gloagen.persistence.dakamon.entity.user.EmailAddress;
import io.gloagen.web.dakamon.processor.EmailAddressProcessor;
import org.apache.commons.validator.routines.EmailValidator;

import javax.inject.Inject;
import java.util.Date;

public class EmailAddressProcessorImpl implements EmailAddressProcessor {

    @Inject EmailService emailService;

    public EmailAddress createEmailAddress(String email) throws InvalidEmailAdressException {
        if (isValidEmailAddress(email)) {
            EmailAddress emailAddress = new EmailAddress();
            emailAddress.setCreated(new Date());
            emailAddress.setEmail(email);
            emailAddress.setValidated(false);
            return emailAddress;
        }
        throw new InvalidEmailAdressException(String.format("The email " + email + " supplied is invalid", email));
    }

    public boolean isValidEmailAddress(String email) {
        return EmailValidator.getInstance().isValid(email);
    }

    public boolean exist(String email) {
        return emailService.find(email) != null;
    }
}
