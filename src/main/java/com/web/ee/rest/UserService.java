package com.web.ee.rest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("user")
public class UserService {
    private static List<User> users;
    static {
        users = Arrays.asList(new User(1, "john", 18),new User(2, "mary", 19),new User(3, "hellen", 20));
    }
    
    @Path("all")
    @GET
    @Produces("application/json")
    public List<User> queryAll() {
        return users;
    }
    
    @Path("{id}")
    @GET
    @Produces("application/json")
    public User getUser(@PathParam("id") int id) {
        Optional<User> optUser = users.stream()
                .filter(u -> u.getId() == id)
                .findFirst();
        return optUser.isPresent()?optUser.get():null;
    }
}
