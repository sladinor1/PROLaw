package com.prolaw.repository; 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.prolaw.prolaw.*;

public class UserImple implements IUser {
    
    private static Logger LOG = LoggerFactory.getLogger(ProlawApplication.class);

    @Override
    public void register(String user){
        LOG.info("SE REGISTRO A: " + user);
    }
}