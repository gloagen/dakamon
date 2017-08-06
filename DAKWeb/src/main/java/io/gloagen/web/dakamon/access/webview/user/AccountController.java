package io.gloagen.web.dakamon.access.webview.user;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

@Path("/account")
public interface AccountController {

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    Response createAccount(MultivaluedMap map);
}
