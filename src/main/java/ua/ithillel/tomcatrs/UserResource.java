package ua.ithillel.tomcatrs;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ua.ithillel.tomcatrs.model.User;
import ua.ithillel.tomcatrs.service.UserService;

import java.util.List;

@Path("users")
public class UserResource {
    @Inject
    private UserService userService;

    // CRUD - create, read, update, delete

    // /users
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<User> getAll() {
        return userService.getUsers();
    }

    // /users/12
    @GET
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public User getById(@PathParam("id") Integer id) {
        return userService.getUserById(id);
    }

    // /users
    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    public void add(User user) {
        userService.addUser(user);
    }

    // /users/12
    @PUT
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public User add(@PathParam("id") Integer id, User newUser) {
        return userService.updateUser(id, newUser);
    }

    @DELETE
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public User delete(@PathParam("id") Integer id) {
        return userService.deleteUser(id);
    }
}
