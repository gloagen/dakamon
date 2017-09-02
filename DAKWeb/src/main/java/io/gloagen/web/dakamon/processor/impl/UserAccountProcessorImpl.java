package io.gloagen.web.dakamon.processor.impl;

import io.gloagen.dak.core.encrypt.HashedPassword;
import io.gloagen.dak.core.exception.InvalidEmailAdressException;
import io.gloagen.dak.core.rest.object.form.user.UserAccountForm;
import io.gloagen.dak.core.util.PasswordUtils;
import io.gloagen.persistence.dakamon.accesslayer.object.UserAccessLayer;
import io.gloagen.persistence.dakamon.entity.auth.UserCredential;
import io.gloagen.persistence.dakamon.entity.user.EmailAddress;
import io.gloagen.persistence.dakamon.entity.user.User;
import io.gloagen.persistence.dakamon.entity.user.UserAccount;
import io.gloagen.persistence.dakamon.entity.user.UserProfile;
import io.gloagen.persistence.dakamon.exception.InvalidUserAccountForm;
import io.gloagen.persistence.dakamon.exception.UserAccountException;
import io.gloagen.web.dakamon.object.UserData;
import io.gloagen.web.dakamon.processor.EmailAddressProcessor;
import io.gloagen.web.dakamon.processor.UserAccountProcessor;

import javax.inject.Inject;
import javax.transaction.Transactional;

@Transactional
public class UserAccountProcessorImpl implements UserAccountProcessor {

    @Inject PasswordUtils passwordUtils;
    @Inject
    private UserAccessLayer userAccessLayer;
    @Inject
    private EmailAddressProcessor emailAddressProcessor;

    public UserData createNewUserAccount(UserAccountForm accountForm)
            throws UserAccountException {

        try {

            if (!accountForm.isValidForm()) {
                throw new InvalidUserAccountForm("The form contains invalid entries");
            }

            User user = createUser(accountForm);

            UserCredential credential = createUserCredentials(accountForm);

            UserAccount userAccount = createUserAccount(user, credential);

            EmailAddress emailAdress =
                    emailAddressProcessor.createEmailAddress(accountForm.getEmail(),
                                                             userAccount);
            UserProfile profile = createUserProfile(userAccount);

            UserData userData = new UserData();

            userData.setUserId(user.getId());
            userData.setAccountId(userAccount.getId());
            userData.setEmailAddress(emailAdress.getEmail());

            return userData;
        }
        catch (InvalidUserAccountForm | InvalidEmailAdressException e) {
            throw new UserAccountException("Unable to create new User account ~ " + e.getMessage(), e);
        }

    }

    private UserCredential createUserCredentials(UserAccountForm accountForm) {

        HashedPassword hashedPassword = passwordUtils.generatePasswordHash(
                accountForm.getPassword());

        UserCredential credential = new UserCredential();
        credential.setHashedPassword(hashedPassword.getHash());
        credential.setSecretKey(hashedPassword.getSalt());
        credential.setAccessKey(passwordUtils.generateSalt());

        userAccessLayer.save(credential);

        return credential;
    }

    @Override
    public UserAccount createUserAccount(User user,
            UserCredential credential) {
        UserAccount userAccount = new UserAccount();
        userAccount.setUser(user);
        userAccount.setCredential(credential);
        userAccessLayer.save(userAccount);
        return userAccount;
    }

    @Override
    public User createUser(UserAccountForm accountForm) {
        User user = new User();
        user.setFirstname(accountForm.getFirstname());
        user.setLastname(accountForm.getLastname());
        userAccessLayer.save(user);
        return user;
    }

    @Override
    public UserProfile createUserProfile(UserAccount userAccount) {
        UserProfile profile = new UserProfile();
        profile.setUserAccount(userAccount);
        userAccessLayer.save(profile);
        return profile;

    }
}
