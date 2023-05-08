package com.socialmediarestapi.user;

import java.time.LocalDate;

public record UserModel(int id, String username, LocalDate birthDate) {
}
