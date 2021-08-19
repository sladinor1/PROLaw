package com.prolaw.controller;


import com.prolaw.domain.*;
import com.prolaw.exception.UserNotFoundException;
import com.prolaw.repository.*;

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

import net.minidev.json.JSONObject;



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

	@Autowired
	private LawyerRepository lawyerRepository;


    
	@ResponseBody
	@RequestMapping(path = "/hello")
	public String sayHello(){
		LOG.info("GET called on /hello resource");
		return HELLO_TEXT;
	}

	@ResponseBody
	@RequestMapping(path = "/user/{typeId}/{idUser}/{nameUser}/{lastNameUser}/{celUser}/{emailUser}/{passUser}/{idCity}", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public String addNewUser(@PathVariable("typeId") String typeId,@PathVariable("idUser") String idUser,@PathVariable("idCity") String idCity,@PathVariable("nameUser") String nameUser, @PathVariable("lastNameUser") String lastNameUser, @PathVariable("celUser") String celUser,@PathVariable("emailUser") String emailUser, @PathVariable("passUser") String passUser){
		String passSec = DigestUtils.sha256Hex(passUser);
		String idSec = DigestUtils.sha256Hex(idUser);
		//String celSec = DigestUtils.sha256Hex(celUser);
		User savedUser = userRepository.save(new User(idSec,typeId,nameUser, lastNameUser, celUser, emailUser, passSec,idCity, Provider.LOCAL,"U"));
		LOG.info(savedUser.toString() + " successfully saved into DB.");
		return savedUser.getIdUser();
	}
	//(String espeLaw, String idFirma, User user)
	@ResponseBody
	@RequestMapping(path = "/lawyer/{typeId}/{idUser}/{nameUser}/{lastNameUser}/{celUser}/{emailUser}/{passUser}/{idCity}/{espeLaw}/{idFirma}", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void addNewLawyer(@PathVariable("typeId") String typeId,@PathVariable("idUser") String idUser,@PathVariable("idCity") String idCity,@PathVariable("nameUser") String nameUser, @PathVariable("lastNameUser") String lastNameUser, @PathVariable("celUser") String celUser,@PathVariable("emailUser") String emailUser, @PathVariable("passUser") String passUser,@PathVariable("espeLaw") String espeLaw,@PathVariable("idFirma") String idFirma){
		String passSec = DigestUtils.sha256Hex(passUser);
		String idSec = DigestUtils.sha256Hex(idUser);
		//String celSec = DigestUtils.sha256Hex(celUser);
		User savedUser = userRepository.save(new User(idSec,typeId,nameUser, lastNameUser, celUser, emailUser, passSec,idCity, Provider.LOCAL,"L"));
		Lawyer savedLaw = lawyerRepository.save( new Lawyer(espeLaw,idFirma,idSec));
		LOG.info( savedUser.toString() + savedLaw.toString() + " successfully saved into DB.");
	}

	@ResponseBody
	@GetMapping(path = "/user/{idUser}")
	public JSONObject getUserById(@PathVariable("idUser") String idU){
		LOG.info(idU);
		JSONObject res = new JSONObject();
        try {User u = userRepository.findByIdUser(idU);
			Lawyer l = lawyerRepository.findByIdUser(idU);
			LOG.info("----------------");
			LOG.info(l.getIdUser());
			res.put("user", u);
			res.put("law", l);
			return res;
		} catch( NullPointerException exception){
			LOG.info(exception.toString());
			return null;
		}
	}

	@ResponseBody
	@GetMapping(path = "/user/U/{idUser}")
	public JSONObject getUserId(@PathVariable("idUser") String idU){
		LOG.info(idU);
		JSONObject res = new JSONObject();
        try {User u = userRepository.findByIdUser(idU);
			LOG.info("----------------");
			res.put("user", u);
			return res;
		} catch( NullPointerException exception){
			LOG.info(exception.toString());
			return null;
		}
	}

	@ResponseBody
	@RequestMapping(path = "/user/login/{emailUser}/{passUser}", method = RequestMethod.GET)
	public User loginConfirmation(@PathVariable("emailUser") String emailUser,@PathVariable("passUser")  String passUser ){
		String idUser = userRepository.findByEmailUser(emailUser).getIdUser();
		return userRepository.findById(idUser).map(user -> {
			String passSec = DigestUtils.sha256Hex(passUser);
			boolean result = user.getPassUser().equals(passSec);
			if(result){
				int i = 10547808;
				String idSec = DigestUtils.sha256Hex(Integer.toString(i));
				LOG.info(LOGIN_DONE);
				LOG.info(idSec);
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
