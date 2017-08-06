package io.gloagen.web.dakamon.access.webview.user;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

@Path("/login")
public interface LoginController {


    @POST
    @Produces({MediaType.TEXT_HTML})
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    Response login(MultivaluedMap form);

}
