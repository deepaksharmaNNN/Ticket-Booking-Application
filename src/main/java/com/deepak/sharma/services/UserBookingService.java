package com.deepak.sharma.services;

import com.deepak.sharma.entities.Train;
import com.deepak.sharma.entities.User;
import com.deepak.sharma.util.UserServiceUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


public class UserBookingService {
    private User user;
    private List<User> userList;
    private final TrainService trainService = new TrainService();
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final String USERS_PATH = "src/main/java/com/deepak/sharma/localDb/users.json";

    public UserBookingService(User user) throws IOException {
        this.user = user;
        loadUsers();
    }

    public void loadUsers() throws IOException {
        File usersFile = new File(USERS_PATH);
        objectMapper.readValue(usersFile, new TypeReference<List<User>>() {
        });
    }
    public UserBookingService() throws IOException {
        loadUsers();
    }
    public List<Train> getTrains(String source, String destination) {
        return trainService.searchTrains(source, destination);
    }

    public Boolean loginUser(User user){
        Optional<User> foundUser = userList.stream().filter(u -> {
            return u.getName().equals(user.getName()) && UserServiceUtil.checkPassword(user.getPassword(), u.getHashedPassword());
        }).findFirst();
        return foundUser.isPresent();
    }
    public Boolean signUp(User user){
        try{
            userList.add(user);
            saveUserListToFile();
            return Boolean.TRUE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }
    private void saveUserListToFile() throws IOException {
        objectMapper.writeValue(new File(USERS_PATH), userList);
    }

    public void fetchBooking(){
        user.printTickets();
    }
    public Boolean cancelBooking(String ticketId){
        Optional<User> foundUser = userList.stream().filter(u -> u.getName().equals(user.getName())).findFirst();
        if(foundUser.isPresent()){
            User user = foundUser.get();
            return user.cancelTicket(ticketId);
        }
        return Boolean.FALSE;
    }

}
