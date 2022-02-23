package com.stephenlee.projectmanager.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.stephenlee.projectmanager.models.LoginUser;
import com.stephenlee.projectmanager.models.User;
import com.stephenlee.projectmanager.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    // returns all the users
    public List<User> allUsers() {
        return userRepo.findAll();
    }
    // creates a user
    public User createUser(User e) {
        return userRepo.save(e);
    }
    // retrieves a user
    public User findUser(Long id) {
        Optional<User> optionalUser = userRepo.findById(id);
        if(optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            return null;
        }
    }
    
    // deletes a user, not used
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
    
    // registration logic, adds errors to results if validation fails, otherwise saves user to database with hashed password
    public User register(User newUser, BindingResult result) {
		Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
		if (potentialUser.isPresent()) {
			result.rejectValue("email", "Taken", "Email already taken!");
		}
		if (!newUser.getPassword().equals(newUser.getPasswordConfirm())) {
			result.rejectValue("passwordConfirm", "Matches", "The Confirm Password must match Password!");
		}
		if (result.hasErrors()) {
			return null;
		}
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		return userRepo.save(newUser);
	}

    // log in logic, adds errors to results if validation fails, otherwise returns user found from database
	public User login(LoginUser newLogin, BindingResult result) {
		User user = null;
		Optional<User> potentialLogin = userRepo.findByEmail(newLogin.getEmail());
		if (!potentialLogin.isPresent()) {
			result.rejectValue("email", "login", "Invalid Credentials");
		} else {
			user = potentialLogin.get();
			if (!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
				result.rejectValue("password", "login", "Invalid Credentials");
			}
		}
		if (result.hasErrors()) {
			return null;
		}
		return user;
	}
	
	// saves a user directly
	public User saveUser(User user) {
		return userRepo.save(user);
	}
}

