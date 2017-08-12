package io.gloagen.web.dakamon.processor.user.account.impl;

import io.gloagen.dak.core.exception.InvalidEmailAdressException;
import io.gloagen.dak.core.rest.object.form.user.UserAccountForm;
import io.gloagen.persistence.dakamon.accesslayer.object.UserAccessLayer;
import io.gloagen.persistence.dakamon.entity.user.EmailAddress;
import io.gloagen.persistence.dakamon.entity.user.User;
import io.gloagen.persistence.dakamon.entity.user.UserInformation;
import io.gloagen.persistence.dakamon.exception.InvalidUserAccountForm;
import io.gloagen.persistence.dakamon.exception.UserAccountException;
import io.gloagen.web.dakamon.processor.EmailAddressProcessor;
import io.gloagen.web.dakamon.processor.UserAccountProcessor;
import io.gloagen.web.dakamon.processor.user.account.UserAccount;

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


            User user = new User();
            user.setFirstname(accountForm.getFirstname());
            user.setLastname(accountForm.getLastname());
            userAccessLayer.save(user);

            UserInformation userInformation = new UserInformation();
            userInformation.setUser(user);
            userAccessLayer.save(userInformation);

            EmailAddress emailAddress = emailAddressProcessor.createEmailAddress(accountForm.getEmail());
            emailAddress.setUserInformation(user.getInformation());



            //TODO
            return null;
        }
        catch (InvalidUserAccountForm | InvalidEmailAdressException e) {
            throw new UserAccountException("Unable to create new User account ~ " + e.getMessage(), e);
        }

    }
}
