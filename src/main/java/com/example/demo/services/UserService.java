package com.example.demo.services;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {
  
	@Autowired
	private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

   
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Map<String, Object> saveUser(String name, String email , String password,String confirmedPassword) {
  
    Map<String, Object> response=  new HashMap<>();
   User exsitingUser=userRepository.findByEmail(email);
   if(exsitingUser==null)
   {
	   User user=new User();
	   user.setUserrole(2);
	   user.setName(name);
	   user.setEmail(email);
	   user.setPassword(password);
	   user.setConfirmpassword(confirmedPassword);
	   
	   userRepository.save(user);
   response.put("success", exsitingUser) ;
	  
   }
   else {
	   response.put("success", "Email Already Used") ;
   }
        return response;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public User loginUser(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
   
	
	
}
