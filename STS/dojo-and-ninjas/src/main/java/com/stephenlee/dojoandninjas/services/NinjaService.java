package com.stephenlee.dojoandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stephenlee.dojoandninjas.models.Ninja;
import com.stephenlee.dojoandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
    @Autowired
    private NinjaRepository ninjaRepo;

    // returns all the ninjas
    public List<Ninja> allNinjas() {
        return ninjaRepo.findAll();
    }
    // creates a ninja
    public Ninja createNinja(Ninja e) {
        return ninjaRepo.save(e);
    }
    // retrieves a ninja
    public Ninja findNinja(Long id) {
        Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
        if(optionalNinja.isPresent()) {
            return optionalNinja.get();
        } else {
            return null;
        }
    }
    
    public Ninja updateNinja(Long id, Ninja newNinja) {
        Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
        if(optionalNinja.isPresent()) {
            Ninja ninja = optionalNinja.get();
            ninja.setFirstName(newNinja.getFirstName());
            ninja.setLastName(newNinja.getLastName());
            ninja.setAge(newNinja.getAge());
            ninja.setDojo(newNinja.getDojo());
            return ninjaRepo.save(ninja);
        } else {
            return null;
        }
    }
    
    public void deleteNinja(Long id) {
        ninjaRepo.deleteById(id);
    }
}

