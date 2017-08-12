package io.gloagen.web.dakamon.processor;

import io.gloagen.dak.core.rest.object.form.user.UserAccountForm;
import io.gloagen.persistence.dakamon.exception.UserAccountException;
import io.gloagen.web.dakamon.processor.user.account.UserAccount;

public interface UserAccountProcessor {

    UserAccount createNewUserAccount(UserAccountForm accountForm) throws UserAccountException;
}
