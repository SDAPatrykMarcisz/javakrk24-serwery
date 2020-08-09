package com.sda.servlety;

public class UserEntity {
    private String user;
    private String password;

    public UserEntity(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public UserEntity() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
