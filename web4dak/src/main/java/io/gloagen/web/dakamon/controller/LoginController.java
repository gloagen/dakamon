package io.gloagen.web.dakamon.controller;

import io.gloagen.dak.core.exception.InvalidEmailAdressException;
import io.gloagen.dak.core.exception.InvalidUsernameOrPasswordException;

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
    @Produces({MediaType.TEXT_PLAIN})
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    Response login(MultivaluedMap form) throws InvalidUsernameOrPasswordException, InvalidEmailAdressException;

}
