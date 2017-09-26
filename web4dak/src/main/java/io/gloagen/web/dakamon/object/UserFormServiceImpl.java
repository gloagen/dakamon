package io.gloagen.web.dakamon.object;

import io.gloagen.dak.core.rest.object.form.user.LoginForm;
import io.gloagen.dak.core.rest.object.form.user.UserAccountForm;
import io.gloagen.dak.core.rest.object.form.user.UserFormService;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MultivaluedMap;

public class UserFormServiceImpl implements UserFormService {

    public LoginForm parseLoginForm(MultivaluedMap map, HttpServletRequest request) {

        LoginForm loginForm = new LoginForm();
        loginForm.setUsername(String.valueOf(map.getFirst("username")));
        loginForm.setPassword(String.valueOf(map.getFirst("password")));
        loginForm.setClientOperatingSystem(request.getHeader("User-Agent"));
        loginForm.setRemoteHost(request.getRemoteAddr());

        return loginForm;

    }

    public UserAccountForm parseUserAccountForm(MultivaluedMap map) {

        UserAccountForm userAccountForm = new UserAccountForm();

        userAccountForm.setAction(String.valueOf(map.getFirst("action")));
        userAccountForm.setEmail(String.valueOf(map.getFirst("email")));
        userAccountForm.setFirstname(String.valueOf(map.getFirst("firstname")));
        userAccountForm.setLastname(String.valueOf(map.getFirst("lastname")));
        userAccountForm.setPassword(String.valueOf(map.getFirst("password")));

        return userAccountForm;
    }
}
