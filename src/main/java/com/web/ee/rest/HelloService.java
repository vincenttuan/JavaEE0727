package com.web.ee.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("hello")
public class HelloService {
    @Path("hi")
    @GET
    @Produces("text/plain")
    public String hi() {
        return "Hi REST !";
    }
    
    @Path("greet")
    @GET
    @Produces("text/plain")
    public String greet(@QueryParam("name") String name) {
        return "Hello1 " + name;
    }
    
    @Path("{name}")
    @GET
    @Produces("text/plain")
    public String hello(@PathParam("name") String name) {
        return "Hello2 " + name;
    }
    
    @Path("{x}/{y}")
    @GET
    @Produces("text/plain")
    public String add(@PathParam("x") Integer x, @PathParam("y") Integer y) {
        return "sum = " + (x + y);
    }
    
}
