package com.parking.parkinglot.common;

public class UserDto {
    private long id;
    private String username;
    private String email;

    // Constructor
    public UserDto(String username, String email, long id) {
        this.username = username;
        this.email = email;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}