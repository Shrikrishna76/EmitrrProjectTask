package com.example.demo.services;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Language;
import com.example.demo.model.Progress;
import com.example.demo.model.User;
import com.example.demo.repository.ProgressRepository;

@Service
public class ProgressService {

	private  ProgressRepository progressRepository;
	
	
	
	@Autowired
	 public ProgressService(ProgressRepository progressRepository) {
		
		this.progressRepository = progressRepository;
	}




	public Progress saveProgress(Progress progress) {
	        System.out.println("Saving user: " + progress);
	        return progressRepository.save(progress);
	    }

	public List<Progress> getAllProgress() {
        return progressRepository.findAllByUsernameIsNotNull();
    }
}
