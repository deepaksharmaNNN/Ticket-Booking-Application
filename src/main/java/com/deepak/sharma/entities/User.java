package com.deepak.sharma.entities;

import java.util.List;

public class User {
    private String userId;
    private String name;
    private String password;
    private String hashedPassword;
    private List<Ticket> ticketsBooked;

    public String getUserId() {
        return userId;
    }

    public List<Ticket> getTicketsBooked() {
        return ticketsBooked;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
