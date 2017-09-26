package io.gloagen.web.dakamon.processor;

import io.gloagen.dak.core.exception.InvalidEmailAdressException;
import io.gloagen.dak.core.exception.InvalidUsernameOrPasswordException;
import io.gloagen.dak.core.exception.UserNotFoundException;
import io.gloagen.dak.core.rest.object.form.user.LoginForm;
import io.gloagen.persistence.dakamon.entity.auth.UserCredential;
import io.gloagen.persistence.dakamon.entity.user.UserAccount;

public interface LoginProcessor {

    String login(String usernameOrEmail, String password, String remoteHost, String clientOperatingSystem)
            throws InvalidUsernameOrPasswordException, InvalidEmailAdressException;

    UserCredential getCredential(String usernameOrEmail) throws UserNotFoundException, InvalidEmailAdressException;

    UserAccount retrieveUserAccount(String usernameOrEmail) throws UserNotFoundException, InvalidEmailAdressException;

    String login(LoginForm loginForm) throws InvalidUsernameOrPasswordException, InvalidEmailAdressException;
}
