package com.web.ee.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("user")
public class UserService {
    private static List<User> users;
    static {
        //users = Arrays.asList(new User(1, "john", 18),new User(2, "mary", 19),new User(3, "hellen", 20));
        users = new ArrayList<>();
        users.add(new User(1, "john", 18));
        users.add(new User(2, "mary", 19));
        users.add(new User(3, "hellen", 20));
    }
    
    // http://localhost:8080/JavaEE0727/rest/user/all
    @Path("all")
    @GET
    @Produces("application/json")
    public List<User> queryAll() {
        return users;
    }
    
    // http://localhost:8080/JavaEE0727/rest/user/1
    @Path("{id}")
    @GET
    @Produces("application/json")
    public User getUser(@PathParam("id") int id) {
        Optional<User> optUser = users.stream()
                .filter(u -> u.getId() == id)
                .findFirst();
        return optUser.isPresent()?optUser.get():null;
    }
    
    // http://localhost:8080/JavaEE0727/rest/user/
    @Path("/")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Message addUser(User user) {
        users.add(user);
        return new Message("add ok", 200);
    }
    
    // http://localhost:8080/JavaEE0727/rest/user/1
    @Path("{id}")
    @PUT
    @Produces("application/json")
    @Consumes("application/json")
    public Message updateUser(@PathParam("id") int id, User user) {
        Optional<User> optUser = users.stream().filter(u -> u.getId() == id).findFirst();
        if(optUser.isPresent()) {
            User u = optUser.get();
            u.setName(user.getName());
            u.setAge(user.getAge());
            return new Message("update ok", 201);
        } else {
            return new Message("update error", -1);
        }
    }
    
    // http://localhost:8080/JavaEE0727/rest/user/1
    @Path("{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response deleteUser(@PathParam("id") int id) {
        boolean check = users.removeIf(u -> u.getId() == id);
        Response resp = Response.ok()
                .header("status", 200)
                .encoding("UTF-8")
                .entity(new Message("刪除成功 ok", 202))
                .build();
        Response resp2 = Response.ok()
                .header("status", 200)
                .encoding("UTF-8")
                .entity(new Message("刪除失敗 error", -2))
                .build();
        return check ? resp : resp2;
    }
    
}
