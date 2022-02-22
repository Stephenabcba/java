package com.stephenlee.studentrosterii.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stephenlee.studentrosterii.models.SWClass;
import com.stephenlee.studentrosterii.repositories.SWClassRepository;

@Service
public class SWClassService {
    @Autowired
    private SWClassRepository swClassRepo;

    // returns all the swClasss
    public List<SWClass> allSWClasses() {
        return swClassRepo.findAll();
    }
    // creates a swClass
    public SWClass createSWClass(SWClass e) {
        return swClassRepo.save(e);
    }
    // retrieves a swClass
    public SWClass findSWClass(Long id) {
        Optional<SWClass> optionalSWClass = swClassRepo.findById(id);
        if(optionalSWClass.isPresent()) {
            return optionalSWClass.get();
        } else {
            return null;
        }
    }
    
    public SWClass updateSWClass(Long id, SWClass newSWClass) {
        Optional<SWClass> optionalSWClass = swClassRepo.findById(id);
        if(optionalSWClass.isPresent()) {
            SWClass swClass = optionalSWClass.get();
            // TODO add all attributes from new model into the instance
            return swClassRepo.save(swClass);
        } else {
            return null;
        }
    }
    
    public void deleteSWClass(Long id) {
        swClassRepo.deleteById(id);
    }
}

