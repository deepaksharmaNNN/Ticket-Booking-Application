package com.deepak.sharma.services;

import com.deepak.sharma.entities.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class UserBookingService {
    private User user;
    private List<User> userList;
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final String USERS_PATH = "src/main/java/com/deepak/sharma/localDb/users.json";

    public UserBookingService(User user) throws IOException {
        this.user = user;
        File usersFile = new File(USERS_PATH);
        userList = objectMapper.readValue(usersFile, new TypeReference<List<User>>() {});
    }
    public boolean loginUser(){
        Optional<User> foundUser = userList.stream().filter(u -> {
            return u.getName().equals(user.getName()) && u.getHashedPassword().equals(user.getHashedPassword());
        }).findFirst();
        return foundUser.isPresent();
    }

}
