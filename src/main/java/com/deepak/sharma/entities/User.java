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

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public void setTicketsBooked(List<Ticket> ticketsBooked) {
        this.ticketsBooked = ticketsBooked;
    }

    public User() {
    }

    public User(String userId, String name, String password, String hashedPassword, List<Ticket> ticketsBooked) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.hashedPassword = hashedPassword;
        this.ticketsBooked = ticketsBooked;
    }

    public void printTickets(){
        for(Ticket ticket: ticketsBooked){
            System.out.println(ticket.getTicketInfo());
        }
    }

    public Boolean cancelTicket(String ticketId) {
        for(Ticket ticket: ticketsBooked){
            if(ticket.getTicketId().equals(ticketId)){
                ticketsBooked.remove(ticket);
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
}
