package io.gloagen.web.dakamon.processor.impl;

import io.gloagen.dak.core.exception.InvalidEmailAdressException;
import io.gloagen.dak.core.exception.InvalidUsernameOrPasswordException;
import io.gloagen.dak.core.exception.UserNotFoundException;
import io.gloagen.dak.core.rest.object.form.user.LoginForm;
import io.gloagen.dak.core.util.PasswordUtils;
import io.gloagen.dak.core.util.TokenGenerator;
import io.gloagen.persistence.dakamon.accesslayer.object.AuthenticationAccessLayer;
import io.gloagen.persistence.dakamon.accesslayer.object.UserAccessLayer;
import io.gloagen.persistence.dakamon.entity.auth.AccessToken;
import io.gloagen.persistence.dakamon.entity.auth.UserCredential;
import io.gloagen.persistence.dakamon.entity.user.UserAccount;
import io.gloagen.web.dakamon.processor.EmailAddressProcessor;
import io.gloagen.web.dakamon.processor.LoginProcessor;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.Date;

@Transactional
public class LoginProcessorImpl implements LoginProcessor {

    public static final int SESSION_EXPIRES_MINUTES = 15;
    static Logger logger = LogManager.getLogger(LoginProcessor.class);
    @Inject
    private PasswordUtils passwordUtils;
    @Inject
    private UserAccessLayer userAccessLayer;
    @Inject
    private EmailAddressProcessor emailAddressProcessor;
    @Inject
    private AuthenticationAccessLayer authenticationLayer;
    @Inject
    private TokenGenerator tokenGenerator;

    @Override
    public String login(String usernameOrEmail, String password, String remoteHost, String clientOperatingSystem)
            throws InvalidUsernameOrPasswordException, InvalidEmailAdressException {

        String token = null;

        try {

            UserCredential credentials = getCredential(usernameOrEmail);

            if (isValidPassword(password, credentials)) {
                token = tokenGenerator.generateToken();
                AccessToken accessToken = buildAccessToken(token, credentials, remoteHost, clientOperatingSystem);

                authenticationLayer.save(accessToken);
            }
        }
        catch (UserNotFoundException e) {
            throw new InvalidUsernameOrPasswordException(e);
        }

        if (token == null) {
            throw new InvalidUsernameOrPasswordException();
        }

        return token;

    }

    public AccessToken buildAccessToken(String token, UserCredential credentials, String remoteHost,
            String clientOperatingSystem) {

        AccessToken accessToken = new AccessToken();

        accessToken.setUserCredential(credentials);
        accessToken.setCreated(new Date());
        accessToken.setExpires(DateUtils.addMinutes(accessToken.getCreated(), SESSION_EXPIRES_MINUTES));
        accessToken.setToken(token);

        accessToken.setRemoteHost(remoteHost);
        accessToken.setClientOperatingSystem(clientOperatingSystem);

        accessToken.setValid(Boolean.TRUE);

        return accessToken;
    }

    public boolean isValidPassword(String password, UserCredential credentials) {
        return passwordUtils.compare(credentials.getHashedPassword(), password);
    }

    @Override
    public UserCredential getCredential(String usernameOrEmail)
            throws UserNotFoundException, InvalidEmailAdressException {
        UserAccount userAccount = retrieveUserAccount(usernameOrEmail);
        return userAccount.getCredential();
    }

    @Override
    public UserAccount retrieveUserAccount(String usernameOrEmail)
            throws UserNotFoundException, InvalidEmailAdressException {

        UserAccount userAccount = null;
        try {
            userAccount = (emailAddressProcessor.isValidEmailAddress(usernameOrEmail)) ?
                          userAccessLayer.findAccountByEmail(
                                  usernameOrEmail) : userAccessLayer.findAccountByUsername(usernameOrEmail);
        }
        catch (NoResultException nre) {
            logger.warn("nothing found " + nre.getMessage(), nre);
        }
        finally {
            if (userAccount == null) {
                throw new UserNotFoundException("User name or email: " + usernameOrEmail + " does not exist");
            }

            return userAccount;
        }

    }

    @Override
    public String login(LoginForm loginForm) throws InvalidUsernameOrPasswordException, InvalidEmailAdressException {
        return login(loginForm.getUsername(), loginForm.getPassword(), loginForm.getRemoteHost(),
                     loginForm.getClientOperatingSystem());
    }
}
