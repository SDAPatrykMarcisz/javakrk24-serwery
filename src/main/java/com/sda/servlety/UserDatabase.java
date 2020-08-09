package com.sda.servlety;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserDatabase {

    private final static UserDatabase INSTANCE;

    static {
        INSTANCE = new UserDatabase();
    }

    public static UserDatabase getInstance() {
        return INSTANCE;
    }

    private Map<String, UserEntity> databaseMock;
    private UserDatabase() {
        this.databaseMock = new HashMap<>();
        databaseMock.put("user", new UserEntity("user", "user123"));
        databaseMock.put("admin", new UserEntity("admin", "admin123"));
    }

    public Optional<UserEntity> findUserByLogin(String login){
        return Optional.ofNullable(databaseMock.get(login));
    }

}
