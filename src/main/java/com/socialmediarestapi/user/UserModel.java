package com.socialmediarestapi.user;
import java.time.LocalDate;
import jakarta.validation.constraints.*;
public class UserModel{
    private int id;
    @Size(min = 8, max = 100)
    private String username;
    @Past
    private LocalDate birthDate;

    public UserModel(){}

    public UserModel(int id, String username, LocalDate birthDate) {
        this.id = id;
        this.username = username;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getUsername() {
        return username;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
