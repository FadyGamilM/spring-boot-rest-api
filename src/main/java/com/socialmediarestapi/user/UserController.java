package com.socialmediarestapi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDao _userDao;
    public UserController(UserDao userDao){
        this._userDao = userDao;
    }

    @GetMapping(path = "/api/users")
    public List<UserModel> GetAllUsers(){
        return _userDao.GetAll();
    }

    @GetMapping(path = "/api/users/{userId}")
    public UserModel GetUserById(@PathVariable int userId){
        return _userDao.GetById(userId);
    }
}
