package com.prolaw.service;

import com.prolaw.repository.IUser;
import com.prolaw.repository.UserImple;

public class UserServiceImple implements IUserService {

    private IUser repo;

    @Override
    public void register(String user){
        repo = new UserImple();
        repo.register(user);
    }
}