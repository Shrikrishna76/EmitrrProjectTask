package com.example.demo.repository;

import com.example.demo.model.Questions;
import com.example.demo.model.User;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionsRepository extends JpaRepository<Questions, Long> {
	@Query("SELECT q FROM Questions q WHERE q.language.id = :languageId")
	List<Questions> findByLanguageId(Long languageId);
	
	   
}
