package com.prolaw.service;

import com.prolaw.domain.Provider;
import com.prolaw.domain.User;
import com.prolaw.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import java.util.List;

@Service
public class UserService {

    @Autowired
    private static UserRepository repo;

    public static void processOAuthPostLogin(String emailUser){
        User userEmail = repo.findByEmailUser(emailUser);
            if (userEmail == null){
                User newUser = new User();
                newUser.setEmailUser(emailUser);
                newUser.setProvider(Provider.GOOGLE);
                repo.save(newUser);
            }

    }
}
