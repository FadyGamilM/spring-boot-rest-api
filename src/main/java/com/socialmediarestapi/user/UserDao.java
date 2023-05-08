package com.socialmediarestapi.user;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {
    private static List<UserModel> _users = new ArrayList<>(){};

    static {
        _users.addAll(
                List.of(
                        new UserModel(1, "fadyGamil", LocalDate.now().minusYears(5)),
                        new UserModel(2, "magyMagdy", LocalDate.now().minusYears(10)),
                        new UserModel(3, "SaidMostafa", LocalDate.now().minusYears(7))
                )
        );
    }

    // TODO: find all users
    public List<UserModel> GetAll(){
        return _users;
    }

    // TODO: find specific user by id
    public UserModel GetById(int userId){
        return _users.stream().filter(user -> user.id() == userId).findFirst().get();
    }

    // TODO: delete a user by id

    // TODO: create new user
}
