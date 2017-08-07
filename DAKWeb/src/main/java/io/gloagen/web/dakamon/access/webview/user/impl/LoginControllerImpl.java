package io.gloagen.web.dakamon.access.webview.user.impl;

import io.gloagen.dak.core.rest.object.form.user.LoginForm;
import io.gloagen.dak.core.rest.object.form.user.UserFormService;
import io.gloagen.web.dakamon.access.webview.user.LoginController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

public class LoginControllerImpl implements LoginController {

    static final Logger logger = LogManager.getLogger(LoginController.class);

    @Inject UserFormService userFormService;

    public Response login(MultivaluedMap form) {

        LoginForm loginForm = userFormService.parseLoginForm(form);

        return Response.ok(loginForm.toString()).build();
    }
}
