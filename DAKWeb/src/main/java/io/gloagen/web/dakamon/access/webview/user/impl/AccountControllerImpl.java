package io.gloagen.web.dakamon.access.webview.user.impl;

import io.gloagen.dak.core.rest.object.form.user.UserAccountForm;
import io.gloagen.dak.core.rest.object.form.user.UserFormService;
import io.gloagen.persistence.dakamon.exception.UserAccountException;
import io.gloagen.web.dakamon.access.webview.user.AccountController;
import io.gloagen.web.dakamon.processor.UserAccountProcessor;
import io.gloagen.web.dakamon.processor.user.account.UserAccount;

import javax.inject.Inject;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

public class AccountControllerImpl implements AccountController {

    @Inject
    private UserFormService formService;

    @Inject
    private UserAccountProcessor userAccountProcessor;

    public Response createAccount(MultivaluedMap map) {
        UserAccountForm accountForm = formService.parseUserAccountForm(
                map);

        try {
            UserAccount userAccount = userAccountProcessor.createNewUserAccount(
                    accountForm);
        }
        catch (UserAccountException e) {
            e.printStackTrace();
        }

        return null;
    }
}
