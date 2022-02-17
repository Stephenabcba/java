package com.stephenlee.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stephenlee.studentroster.models.Dorm;
import com.stephenlee.studentroster.repositories.DormRepository;

@Service
public class DormService {
    @Autowired
    private DormRepository dormRepo;

    // returns all the dorms
    public List<Dorm> allDorms() {
        return dormRepo.findAll();
    }
    // creates a dorm
    public Dorm createDorm(Dorm e) {
        return dormRepo.save(e);
    }
    // retrieves a dorm
    public Dorm findDorm(Long id) {
        Optional<Dorm> optionalDorm = dormRepo.findById(id);
        if(optionalDorm.isPresent()) {
            return optionalDorm.get();
        } else {
            return null;
        }
    }
    
    public Dorm updateDorm(Long id, Dorm newDorm) {
        Optional<Dorm> optionalDorm = dormRepo.findById(id);
        if(optionalDorm.isPresent()) {
            Dorm dorm = optionalDorm.get();
            dorm.setName(newDorm.getName());
            dorm.setStudents(newDorm.getStudents());
            return dormRepo.save(dorm);
        } else {
            return null;
        }
    }
    
    public void deleteDorm(Long id) {
        dormRepo.deleteById(id);
    }
}

