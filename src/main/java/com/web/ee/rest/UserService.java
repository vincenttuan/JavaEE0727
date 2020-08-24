package com.web.ee.rest;

import java.util.Arrays;
import java.util.List;
import javax.ws.rs.Path;

@Path("user")
public class UserService {
    private static List<User> users;
    static {
        users = Arrays.asList(new User("john", 18),new User("mary", 19),new User("hellen", 20));
    }
}
