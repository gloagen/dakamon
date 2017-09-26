package io.gloagen.web.dakamon.controller.impl;

import io.gloagen.dak.core.exception.InvalidEmailAdressException;
import io.gloagen.dak.core.exception.InvalidUsernameOrPasswordException;
import io.gloagen.dak.core.rest.object.form.user.LoginForm;
import io.gloagen.dak.core.rest.object.form.user.UserFormService;
import io.gloagen.web.dakamon.controller.LoginController;
import io.gloagen.web.dakamon.processor.LoginProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

public class LoginControllerImpl implements LoginController {

    static final Logger logger = LogManager.getLogger(LoginController.class);

    @Inject UserFormService userFormService;
    @Context HttpServletRequest request;
    @Inject
    private LoginProcessor loginProcessor;

    public Response login(MultivaluedMap form) throws InvalidUsernameOrPasswordException, InvalidEmailAdressException {

        LoginForm loginForm = userFormService.parseLoginForm(form, request);
        String token = loginProcessor.login(loginForm);
        return Response.ok(token).build();

        //TODO handle excetion including invalid username and password!
    }
}
