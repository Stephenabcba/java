package com.stephenlee.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.stephenlee.bookclub.models.LoginUser;
import com.stephenlee.bookclub.models.User;
import com.stephenlee.bookclub.repositories.UserRepository;

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
    
    public User register(User newUser, BindingResult result) {
		if (result.hasErrors()) {
			return null;
		}
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

	public User login(LoginUser newLogin, BindingResult result) {
		if (result.hasErrors()) {
			return null;
		}
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
    
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
}

