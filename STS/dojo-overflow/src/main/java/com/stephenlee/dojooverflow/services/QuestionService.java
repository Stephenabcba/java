package com.stephenlee.dojooverflow.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stephenlee.dojooverflow.models.Answer;
import com.stephenlee.dojooverflow.models.Question;
import com.stephenlee.dojooverflow.models.Tag;
import com.stephenlee.dojooverflow.repositories.AnswerRepository;
import com.stephenlee.dojooverflow.repositories.QuestionRepository;
import com.stephenlee.dojooverflow.repositories.TagRepository;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepo;
    
    @Autowired
    private TagRepository tagRepo;

    // returns all the questions
    public List<Question> allQuestions() {
        return questionRepo.findAll();
    }
    // creates a question
    public Question createQuestion(Question q) {
    	q.setTags(new ArrayList<Tag>());
    	String[] tagStrings = q.getTagInput().split(",", 3);
    	for (String tagString: tagStrings) {
    		tagString = tagString.trim();
    		Optional<Tag> potentialTag = tagRepo.findBySubject(tagString);
    		if (potentialTag.isPresent()) {
    			q.getTags().add(potentialTag.get());
    		} else {
    			q.getTags().add(tagRepo.save(new Tag(tagString)));
    		}
    	}
        return questionRepo.save(q);
    }
    // retrieves a question
    public Question findQuestion(Long id) {
        Optional<Question> optionalQuestion = questionRepo.findById(id);
        if(optionalQuestion.isPresent()) {
            return optionalQuestion.get();
        } else {
            return null;
        }
    }
    
    public Question saveQuestion(Question question) {
    	return questionRepo.save(question);
    }
}

