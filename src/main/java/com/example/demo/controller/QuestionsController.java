package com.example.demo.controller;

import com.example.demo.model.Questions;
import com.example.demo.services.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/questions")
public class QuestionsController {

    @Autowired
    private QuestionsService questionsService;

    @GetMapping
    public List<Questions> getAllQuestions() {
        return questionsService.getAllQuestions();
    }

    @GetMapping("/{id}")
    public Optional<Questions> getQuestionById(@PathVariable Long id) {
        return questionsService.getQuestionById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveQuestion(@RequestBody Questions question) {
        questionsService.saveQuestion(question);
        return ResponseEntity.ok("Question saved successfully");
    }


    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable Long id) {
        questionsService.deleteQuestion(id);
    }
    
    @GetMapping("/byLanguage/{languageId}")
    public List<Questions> getQuestionsByLanguageId(@PathVariable Long languageId) {
        return questionsService.getQuestionsByLanguageId(languageId);
    }
}
