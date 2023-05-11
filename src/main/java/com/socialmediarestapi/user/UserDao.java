package com.socialmediarestapi.user;

import com.socialmediarestapi.exceptions.NotFoundException;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {
    private static List<UserModel> _users = new ArrayList<>(){};
    private static int usersCount = 0;

    static {
        _users.addAll(
                List.of(
                        new UserModel(++usersCount, "fadyGamil", LocalDate.now().minusYears(5)),
                        new UserModel(++usersCount, "magyMagdy", LocalDate.now().minusYears(10)),
                        new UserModel(++usersCount, "SaidMostafa", LocalDate.now().minusYears(7))
                )
        );
    }

    // TODO: find all users
    public List<UserModel> GetAll(){
        return _users;
    }

    // TODO: find specific user by id
    public UserModel GetById(int userId){
        return _users.stream()
                .filter(user -> user.getId() == userId)
                .findFirst()
                .orElseThrow(() -> new NotFoundException("user is not found"));
    }

    // TODO: create new user
    public UserModel Create(UserModel user){
        user.setId(++usersCount);
        _users.add(user);
        return user;
    }

    // TODO: delete a user by id
    public void DeleteById(int userId){
        // first we need to find the user to ensure that there is an user exist or not
        var existingUser = _users.stream()
                .filter(u -> u.getId() == userId)
                .findFirst()
                .orElseThrow(() -> new NotFoundException("there is no user with given id to be removed"));
        _users.removeIf(u -> u.getId() == userId);
    }

}
