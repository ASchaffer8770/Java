package com.alexschaffer.auth.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.alexschaffer.auth.models.LoginUser;
import com.alexschaffer.auth.models.User;
import com.alexschaffer.auth.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
    //Logic for additional validations for registration
    public User register(User newUser, BindingResult result) {
        // Additional validations
    	
    	// Reject if email is taken (Present in DB)
    	
    	// 1. Find User in the DB by email
    	Optional<User> optionalUser = userRepo.findByEmail(newUser.getEmail());
    	
    	// 2. If the email is present (in DB), reject
    	if(optionalUser.isPresent()) {
    		result.rejectValue("email", "Unique", "Email is already registered!");
    	}
    	
    	// 3. Reject if PW doesn't match DB PW
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    		result.rejectValue("confirm", "Matches", "Passwords must match!");
    	}
    	
    	// 4. Return null if result has errors
    	if(result.hasErrors()) {
    		return null;
    	}
    	
    	// 5. HASH AND SET PW, save user to DB
    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashed);
        return userRepo.save(newUser);
    }
    
    public User login(LoginUser newLogin, BindingResult result) {
    	// TO-DO - Reject values:
    	
    	// 1. Find user in DB by email
    	Optional<User> optionalUser = userRepo.findByEmail(newLogin.getEmail());
    	
    	// 2. If email is not present, reject
    	if(!optionalUser.isPresent()) {
    		result.rejectValue("email", "Unique", "Email is not registered!");
    		return null;
    	}
    	
    	// 3.1 Grab the user from the potentialUser
    	User user = optionalUser.get();
   	
    	// 3.2 if Bcrypt PW match fails, reject
    	if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
    	    result.rejectValue("password", "Matches", "Invalid Password!");
    	}
    	
    	// 4. If result hasErrors, return
    	if(result.hasErrors()) {
    		return null;
    	}
    	
    	// 5. Otherwise, return user Object
    	
    	
    	return user;
    }
    
}





