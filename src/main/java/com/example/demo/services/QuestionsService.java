package com.example.demo.services;

import com.example.demo.model.Questions;
import com.example.demo.repository.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionsService {

    @Autowired
    private QuestionsRepository questionsRepository;

    public List<Questions> getAllQuestions() {
        return questionsRepository.findAll();
    }

    public Optional<Questions> getQuestionById(Long id) {
        return questionsRepository.findById(id);
    }

    public Questions saveQuestion(Questions question) {
        return questionsRepository.save(question);
    }

    public void deleteQuestion(Long id) {
        questionsRepository.deleteById(id);
    }
    
    public List<Questions> getQuestionsByLanguageId(Long languageId) {
        return questionsRepository.findByLanguageId(languageId);
    }
}
