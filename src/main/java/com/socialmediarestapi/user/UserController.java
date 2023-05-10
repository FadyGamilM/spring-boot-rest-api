package com.socialmediarestapi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDao _userDao;

    public UserController(UserDao userDao) {
        this._userDao = userDao;
    }

    @GetMapping(path = "/api/users")
    public List<UserModel> GetAllUsers() {
        return _userDao.GetAll();
    }

    @GetMapping(path = "/api/users/{userId}")
    public UserModel GetUserById(@PathVariable int userId) {
        return _userDao.GetById(userId);
    }

    @PostMapping(path = "/api/users")
    public ResponseEntity<UserModel> CreateUser(@RequestBody UserModel user) {
        // get the created user
        var createdUser = _userDao.Create(user);

        // create the uri location
        var location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{userId}")
                .buildAndExpand(createdUser.getId())
                .toUri(); // now we send this uri to the header of the response so client code

        return ResponseEntity.created(location).build();
    }
}
