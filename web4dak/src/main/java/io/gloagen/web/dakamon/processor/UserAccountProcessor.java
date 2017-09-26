package io.gloagen.web.dakamon.processor;

import io.gloagen.dak.core.rest.object.form.user.UserAccountForm;
import io.gloagen.persistence.dakamon.entity.auth.UserCredential;
import io.gloagen.persistence.dakamon.entity.user.User;
import io.gloagen.persistence.dakamon.entity.user.UserAccount;
import io.gloagen.persistence.dakamon.entity.user.UserProfile;
import io.gloagen.persistence.dakamon.exception.UserAccountException;
import io.gloagen.web.dakamon.object.UserData;

public interface UserAccountProcessor {

    UserData createNewUserAccount(UserAccountForm accountForm) throws UserAccountException;

    UserAccount createUserAccount(User user, UserCredential credential);

    User createUser(UserAccountForm accountForm);

    UserProfile createUserProfile(UserAccount userAccount);
}
