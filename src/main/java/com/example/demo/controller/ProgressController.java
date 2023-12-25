package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Progress;
import com.example.demo.model.User;
import com.example.demo.repository.ProgressRepository;
import com.example.demo.services.ProgressService;
import com.example.demo.services.UserService;

@RestController
@RequestMapping("/api/progress")
public class ProgressController {
	@Autowired
	private ProgressService progressService;
	
	@Autowired
	private UserService userservice;


//	@PostMapping("/save")
//	public ResponseEntity<Progress> saveProgress(@RequestBody Progress progress) {
//	   Progress savedProgress = progressService.saveProgress(progress);
// 
//		
//		return ResponseEntity.ok(savedProgress);
//	} 

//	
//	@PostMapping("/save")
//	public ResponseEntity<Progress> saveProgress(@RequestBody Map<String,String> data) {
//	   
//		String email=data.get("email");
//		String totalScore=data.get("totalScore");
//		String totalPossibleScore=data.get("totalPossibleScore");
//		String timestamp=data.get("timestamp");
//		User user=userservice.getUserByEmail("email");
//		String username=user.getName();
//		
//		Progress p=new Progress();
//		p.setEmail(email);
//		p.setTotalScore(totalScore);
//		p.setTotalPossibleScore(totalPossibleScore);
//		p.setTimestamp(timestamp);
//		p.setUsername(username);
// 
//		
//		return ResponseEntity.ok(p);
//	} 



	@PostMapping("/save")
	public ResponseEntity<Progress> saveProgress(@RequestBody Map<String, String> data) {

	    String email = data.get("email");
	    String totalScore = data.get("totalScore");
	    String totalPossibleScore = data.get("totalPossibleScore");
	    String timestamp = data.get("timestamp");

	    // Retrieve user by email
	    User user = userservice.getUserByEmail(email);

	    // Check if the user is null
	    if (user == null) {
	        // Handle the case where the user is not found
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	    }

	    String username = user.getName();

	    Progress p = new Progress();
	    p.setEmail(email);
	    p.setTotalScore(totalScore);
	    p.setTotalPossibleScore(totalPossibleScore);
	    p.setTimestamp(timestamp);
	    p.setUsername(username);
	    

	    progressService.saveProgress(p);
	    return ResponseEntity.ok(p);
	}
	
	// In ProgressController.java
	@GetMapping("/all")
	public ResponseEntity<List<Progress>> getAllProgress() {
	    List<Progress> progressList = progressService.getAllProgress();
	    return ResponseEntity.ok(progressList);
	}



}
