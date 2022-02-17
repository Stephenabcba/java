package com.stephenlee.dojoandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stephenlee.dojoandninjas.models.Dojo;
import com.stephenlee.dojoandninjas.repositories.DojoRepository;

@Service
public class DojoService {
    @Autowired
    private DojoRepository dojoRepo;

    // returns all the dojos
    public List<Dojo> allDojos() {
        return dojoRepo.findAll();
    }
    // creates a dojo
    public Dojo createDojo(Dojo e) {
        return dojoRepo.save(e);
    }
    // retrieves a dojo
    public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepo.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }
    
    public Dojo updateDojo(Long id, Dojo newDojo) {
        Optional<Dojo> optionalDojo = dojoRepo.findById(id);
        if(optionalDojo.isPresent()) {
            Dojo dojo = optionalDojo.get();
            dojo.setName(newDojo.getName());
            dojo.setNinjas(newDojo.getNinjas());
            return dojoRepo.save(dojo);
        } else {
            return null;
        }
    }
    
    public void deleteDojo(Long id) {
        dojoRepo.deleteById(id);
    }
}


