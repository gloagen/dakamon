package io.gloagen.dak.core.rest.object.form.user;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MultivaluedMap;

public interface UserFormService {

    /**
     * Create a {@link UserAccountForm } object without validating the input arguments
     *
     * @param map
     * @return {@link UserAccountForm }
     */
    UserAccountForm parseUserAccountForm(MultivaluedMap map);

    /**
     * Create a {@link LoginForm } object without validating the input arguments
     *
     * @param map
     * @param request
     * @return {@link LoginForm }
     */
    LoginForm parseLoginForm(MultivaluedMap map, HttpServletRequest request);
}
