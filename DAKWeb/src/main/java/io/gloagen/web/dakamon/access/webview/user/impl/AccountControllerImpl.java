package io.gloagen.web.dakamon.access.webview.user.impl;

import io.gloagen.web.dakamon.access.webview.user.AccountController;

import javax.ws.rs.core.Response;

public class AccountControllerImpl implements AccountController {
    public Response createAccount(/*UserAccountForm accountForm*/) {
        return Response.ok().build();
    }
}
