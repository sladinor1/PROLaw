package com.prolaw.controller;


import com.prolaw.domain.User;
import com.prolaw.exception.UserNotFoundException;
import com.prolaw.repository.UserRepository;
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
	@ResponseBody
	@RequestMapping(path = "/user/{idUser}/{nameUser}/{lastNameUser}/{celUser}/{emailUser}/{passUser}", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public long addNewUser(@PathVariable("idUser") long idUser,@PathVariable("nameUser") String nameUser, @PathVariable("lastNameUser") String lastNameUser, @PathVariable("celUser") String celUser,@PathVariable("emailUser") String emailUser, @PathVariable("passUser") String passUser){
		User savedUser = userRepository.save(new User(idUser,nameUser, lastNameUser, celUser, emailUser, passUser));
		LOG.info(savedUser.toString() + " successfully saved into DB.");
		return savedUser.getIdUser();
	}

	@ResponseBody
	@GetMapping(path = "/user/{idUser}")
	public User getUserById(@PathVariable("idUser") long idUser){
		return userRepository.findById(idUser).map(user -> {
			LOG.info("Reading user with id " + idUser+ " from database.");
			return user;
		}).orElseThrow(() -> new UserNotFoundException("The user with the id "+idUser+ " couldn't be found in the database."));
	}

    @ResponseBody
	@RequestMapping(path = "/secured", method = RequestMethod.GET)
	public String getSecured() {
		LOG.info("GET succesfully called on /secured resource");
		return SECURED_TEXT;
	}
}
