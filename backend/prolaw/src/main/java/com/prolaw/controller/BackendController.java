package com.prolaw.controller;


import com.prolaw.domain.Provider;
import com.prolaw.domain.User;
import com.prolaw.exception.UserNotFoundException;
import com.prolaw.repository.UserRepository;

import org.apache.pulsar.shade.org.apache.commons.codec.digest.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
public class BackendController {
    
	private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);
	   
	public static final String HELLO_TEXT = "Hello from Spring Boot Backend!";
    public static final String SECURED_TEXT = "Hello from the secured resource!";
	public static final String LOGIN_DONE = "Loggin done";
	public static final String LOGIN_ERROR = "Loggin error";

	@Autowired
	private UserRepository userRepository;

	@ResponseBody
	@RequestMapping(path = "/hello")
	public String sayHello(){
		
		LOG.info("GET called on /hello resource");
		return HELLO_TEXT;
	}

	/* Atributos
    private String nameUser;
    private String lastNameUser;
    private Integer celUser;
    private String emailUser;
    private String passUser;
    */
	//@CrossOrigin(origins = "http://localhost:8080")
	@ResponseBody
	@RequestMapping(path = "/user/{typeId}/{idUser}/{nameUser}/{lastNameUser}/{celUser}/{emailUser}/{passUser}/{idCity}", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public String addNewUser(@PathVariable("typeId") String typeId,@PathVariable("idUser") String idUser,@PathVariable("idCity") String idCity,@PathVariable("nameUser") String nameUser, @PathVariable("lastNameUser") String lastNameUser, @PathVariable("celUser") String celUser,@PathVariable("emailUser") String emailUser, @PathVariable("passUser") String passUser){
		String passSec = DigestUtils.sha256Hex(passUser);
		String idSec = DigestUtils.sha256Hex(idUser);
		String celSec = DigestUtils.sha256Hex(celUser);
		User savedUser = userRepository.save(new User(idSec,typeId,nameUser, lastNameUser, celSec, emailUser, passSec,idCity, Provider.LOCAL));
		LOG.info(savedUser.toString() + " successfully saved into DB.");
		return savedUser.getIdUser();
	}

	@ResponseBody
	@GetMapping(path = "/user/{idUser}")
	public User getUserById(@PathVariable("idUser") String idU){
		String idUser = DigestUtils.sha256Hex(idU);
		return userRepository.findById(idUser).map(user -> {
			LOG.info("Reading user with id " + idUser+ " from database.");
			return user;
		}).orElseThrow(() -> new UserNotFoundException("The user with the id "+idUser+ " couldn't be found in the database."));
	}

	@ResponseBody
	@RequestMapping(path = "/user/login/{emailUser}/{passUser}", method = RequestMethod.GET)
	public User loginConfirmation(@PathVariable("emailUser") String emailUser,@PathVariable("passUser")  String passUser ){
		String idUser = userRepository.findByEmailUser(emailUser).getIdUser();
		return userRepository.findById(idUser).map(user -> {
			String passSec = DigestUtils.sha256Hex(passUser);
			boolean result = user.getPassUser().equals(passSec);
			if(result){
				LOG.info(LOGIN_DONE);
				return user;
			}
			return null;
		}).orElseThrow(() -> new UserNotFoundException("The email: "+emailUser+ " and password are not correct"));
	}



    @ResponseBody
	@RequestMapping(path = "/secured", method = RequestMethod.GET)
	public String getSecured() {
		LOG.info("GET succesfully called on /secured resource");
		return SECURED_TEXT;
	}


}
