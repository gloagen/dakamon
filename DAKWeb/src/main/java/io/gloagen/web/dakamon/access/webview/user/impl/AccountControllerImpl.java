package io.gloagen.web.dakamon.access.webview.user.impl;

import io.gloagen.model.dakamon.rest.object.form.user.UserAccountForm;
import io.gloagen.model.dakamon.rest.object.form.user.UserFormService;
import io.gloagen.web.dakamon.access.webview.user.AccountController;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

public class AccountControllerImpl implements AccountController {


    private UserFormService formService;

    public Response createAccount(MultivaluedMap map) {
        UserAccountForm accountForm = formService.parseUserAccountForm(
                map);


        return null;
    }
}
