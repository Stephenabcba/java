package com.stephenlee.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stephenlee.dojooverflow.models.Tag;
import com.stephenlee.dojooverflow.repositories.TagRepository;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepo;

    // returns all the tags
    public List<Tag> allTags() {
        return tagRepo.findAll();
    }
    // creates a tag
    public Tag createTag(Tag e) {
        return tagRepo.save(e);
    }
    // retrieves a tag
    public Tag findTag(Long id) {
        Optional<Tag> optionalTag = tagRepo.findById(id);
        if(optionalTag.isPresent()) {
            return optionalTag.get();
        } else {
            return null;
        }
    }
}

