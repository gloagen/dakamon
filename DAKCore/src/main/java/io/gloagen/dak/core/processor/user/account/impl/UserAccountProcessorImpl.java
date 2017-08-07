package io.gloagen.dak.core.processor.user.account.impl;

import io.gloagen.dak.core.exception.InvalidEmailAdressException;
import io.gloagen.dak.core.processor.exception.InvalidUserAccountForm;
import io.gloagen.dak.core.processor.exception.UserAccountException;
import io.gloagen.dak.core.processor.user.account.EmailAddressProcessor;
import io.gloagen.dak.core.processor.user.account.UserAccount;
import io.gloagen.dak.core.processor.user.account.UserAccountProcessor;
import io.gloagen.dak.core.rest.object.form.user.UserAccountForm;
import io.gloagen.persistence.dakamon.accesslayer.object.UserAccessLayer;
import io.gloagen.persistence.dakamon.entity.user.EmailAddress;

import javax.inject.Inject;

public class UserAccountProcessorImpl implements UserAccountProcessor {

    @Inject
    private UserAccessLayer userAccessLayer;

    @Inject
    private EmailAddressProcessor emailAddressProcessor;


    public UserAccount createNewUserAccount(UserAccountForm accountForm)
            throws UserAccountException {
//        userAccessLayer.


        try {
            //TODO create email (1)
            if (!accountForm.isValidForm()) {
                throw new InvalidUserAccountForm("The form contains invalid entries");
            }

            EmailAddress emailAddress = emailAddressProcessor.createEmailAddress(accountForm.getEmail());


            //TODO
            return null;
        }
        catch (InvalidUserAccountForm | InvalidEmailAdressException e) {
            throw new UserAccountException("Unable to create new User account ~ " + e.getMessage(), e);
        }

    }
}
