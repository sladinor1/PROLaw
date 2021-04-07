package com.prolaw.prolaw;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.prolaw.service.IUserService;
import com.prolaw.service.UserServiceImple;

@SpringBootApplication
public class ProlawApplication implements CommandLineRunner {

	private static Logger LOG = LoggerFactory.getLogger(ProlawApplication.class);
	public IUserService service;

	public static void main(String[] args) {
		SpringApplication.run(ProlawApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		//Revisando USO
		LOG.warn("USANDO DESDE CONSOLA");
		service = new UserServiceImple();
		service.register("HolaMundo");
	}

}
