package io.gloagen.model.dakamon.rest.object.form.user.impl;

import io.gloagen.model.dakamon.rest.object.form.user.LoginForm;
import io.gloagen.model.dakamon.rest.object.form.user.UserAccountForm;
import io.gloagen.model.dakamon.rest.object.form.user.UserFormService;

import javax.ws.rs.core.MultivaluedMap;

public class UserFormServiceImpl implements UserFormService {
    public LoginForm parseLoginForm(MultivaluedMap map) {
        return null;
    }

    public UserAccountForm parseUserAccountForm(MultivaluedMap map) {

        throw new RuntimeException("not implemented");
    }
}
