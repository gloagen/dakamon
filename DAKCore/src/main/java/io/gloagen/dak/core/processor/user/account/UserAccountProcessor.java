package io.gloagen.dak.core.processor.user.account;

import io.gloagen.dak.core.processor.exception.UserAccountException;
import io.gloagen.dak.core.rest.object.form.user.UserAccountForm;

public interface UserAccountProcessor {

    UserAccount createNewUserAccount(UserAccountForm accountForm) throws UserAccountException;
}
