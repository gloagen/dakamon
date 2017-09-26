package io.gloagen.web.dakamon.controller.impl;

import io.gloagen.dak.core.rest.object.form.user.UserAccountForm;
import io.gloagen.dak.core.rest.object.form.user.UserFormService;
import io.gloagen.persistence.dakamon.exception.UserAccountException;
import io.gloagen.web.dakamon.controller.AccountController;
import io.gloagen.web.dakamon.object.UserData;
import io.gloagen.web.dakamon.processor.UserAccountProcessor;

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

            UserData userData = userAccountProcessor.createNewUserAccount(
                    accountForm);
            return Response.ok(userData).build();
        }
        catch (UserAccountException e) {
            e.printStackTrace();
        }

        return null;
    }
}
