//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.gzu.sportsselection.service.sportManagement;

import com.gzu.sportsselection.model.sportManagement.Ground;
import com.gzu.sportsselection.repository.sportManagement.GroundRepository;
import java.util.List;
import java.util.Objects;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroundService {
    GroundRepository groundRepository;

    @Autowired
    public GroundService(GroundRepository groundRepository) {
        this.groundRepository = groundRepository;
    }

    public Ground save(Ground ground) {
        this.groundRepository.save(ground);
        return (Ground)this.groundRepository.findById(ground.getId()).orElseThrow(() -> {
            return new IllegalStateException("Compartment with id: " + ground.getId() + " does not exist");
        });
    }

    public Ground getCompartment(Long id) {
        return (Ground)this.groundRepository.findById(id).orElseThrow(() -> {
            return new IllegalStateException("Compartment with id: " + id + " does not exist");
        });
    }

    public List<Ground> getCompartments() {
        return this.groundRepository.findAll();
    }

    public List<Ground> getCompartmentsForSpecificProperty(Long id) {
        return this.groundRepository.findByProperty(id);
    }

    @Transactional
    public Ground update(Long id, Ground update) {
        Ground ground = (Ground)this.groundRepository.findById(id).orElseThrow(() -> {
            return new IllegalStateException("Ground with id: " + id + " does not exist");
        });
        if (update.getStudent() != null && !Objects.equals(ground.getStudent(), update.getStudent())) {
            ground.setTenant(update.getStudent());
        }

        if (update.getStatus() != null && !Objects.equals(ground.getStatus(), update.getStatus())) {
            ground.setStatus(update.getStatus());
        }

        return (Ground)this.groundRepository.findById(id).orElseThrow(() -> {
            return new IllegalStateException("Ground with id: " + id + " does not exist");
        });
    }

    public List<Ground> getCompartmentsForSpecificTenant(Long id) {
        return this.groundRepository.findByTenant(id);
    }
}
