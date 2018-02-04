package com.sapb.spd;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/")
public class HelloWorldResource {

    @GET
    @Path("hello")
    public Response getHello() {
        return Response.status(Response.Status.OK).entity(new String("Hello World")).build();
    }
}
