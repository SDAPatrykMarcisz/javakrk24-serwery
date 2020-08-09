package com.sda.servlety;

import java.util.Optional;

public class LoginService {

    private static final LoginService INSTANCE;

    static {
        INSTANCE = new LoginService();
    }

    private final UserDatabase userDatabase;

    private LoginService() {
        this.userDatabase = UserDatabase.getInstance();
    }

    public static LoginService getInstance() {
        return INSTANCE;
    }

    public boolean verifyUser(String login, String password){
        Optional<UserEntity> userByLogin = userDatabase.findUserByLogin(login);
        return userByLogin
                .filter(x -> x.getUser().equals(login))
                .filter(x -> x.getPassword().equals(password))
                .isPresent();
    }

}
