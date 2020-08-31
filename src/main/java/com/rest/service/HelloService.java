package com.rest.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("hello")
public class HelloService {
    @Path("hi")
    @GET
    @Produces("text/plain")
    public String sayHi() {
        return "Hi RestApp !";
    }
}
