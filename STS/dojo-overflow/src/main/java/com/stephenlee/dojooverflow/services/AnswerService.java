package com.stephenlee.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stephenlee.dojooverflow.models.Answer;
import com.stephenlee.dojooverflow.repositories.AnswerRepository;

@Service
public class AnswerService {
    @Autowired
    private AnswerRepository answerRepo;

    // returns all the answers
    public List<Answer> allAnswers() {
        return answerRepo.findAll();
    }
    // creates a answer
    public Answer createAnswer(Answer e) {
        return answerRepo.save(e);
    }
}

