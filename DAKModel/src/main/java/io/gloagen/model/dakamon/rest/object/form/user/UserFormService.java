package io.gloagen.model.dakamon.rest.object.form.user;

import javax.ws.rs.core.MultivaluedMap;

public interface UserFormService {

    LoginForm parseLoginForm(MultivaluedMap map);

    UserAccountForm parseUserAccountForm(MultivaluedMap map);
}
