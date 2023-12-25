package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/users")
public class UserController {


	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;

	  

	    @GetMapping("/all")
	    public ResponseEntity<List<User>> getAllUsers() {
	        List<User> users = userService.getAllUsers();
	        return ResponseEntity.ok(users);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<User> getUserById(@PathVariable Long id) {
	        return userService.getUserById(id)
	                .map(ResponseEntity::ok)
	                .orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    @PostMapping("/save")
	    public ResponseEntity<Map<String ,Object> > createUser(@RequestBody User user) {
	    	
	    String name=user.getName();
	    String email=user.getEmail();
	    String password=user.getPassword();
	    String confirmedPassword=user.getConfirmpassword();
	   

	    	Map<String ,Object> response= userService.saveUser(name,email,password,confirmedPassword);
	        
	        return ResponseEntity.ok(response);
	    }

//	    @PutMapping("/{id}")
//	    public ResponseEntity<Map<String ,Object>> updateUser(@PathVariable Long id, @RequestBody User user) {
//	        if (userService.getUserById(id).isPresent()) {
//	            user.setId(id);
//	            Map<String ,Object> response = userService.saveUser(user);
//	            return ResponseEntity.ok(response);
//	        } else {
//	            return ResponseEntity.notFound().build();
//	        }
//	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
	        if (userService.getUserById(id).isPresent()) {
	            userService.deleteUser(id);
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @PostMapping("/authenticate")
	    public ResponseEntity<Boolean> authenticateUser(@RequestBody User loginUser) {
	        // Check if the user with the provided email and password exists
	        User existingUser = userRepository.findByEmailAndPassword(loginUser.getEmail(), loginUser.getPassword());

	        if (existingUser != null) {
	            return ResponseEntity.ok(true); // User exists, return success
	        } else {
	            return ResponseEntity.ok(false); // User does not exist, return failure
	        }
	    }

	    
	    @GetMapping("/by-email/{email}")
	    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
	        User user = userService.getUserByEmail(email);
	        return ResponseEntity.ok(user);
	    }

	    @PostMapping("/login")
	    public ResponseEntity<User> loginUser(@RequestBody User loginUser) {
	        User user = userService.loginUser(loginUser.getEmail(), loginUser.getPassword());

	        if (user != null) {
	            return ResponseEntity.ok(user);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

}
