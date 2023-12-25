package com.example.demo.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Progress;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long> {

	@Modifying
	    @Query(value = "INSERT INTO progress_table (email,total_score, total_possible_score, timestamp) VALUES (:email,  :totalScore, :totalPossibleScore, :timestamp)", nativeQuery = true)
	    void saveProgress(
	        @Param("email") String email,
	        @Param("totalScore") double totalScore,
	        @Param("totalPossibleScore") double totalPossibleScore,
	        @Param("timestamp") Date timestamp
	    );
	

	List<Progress> findAllByUsernameIsNotNull();
}
