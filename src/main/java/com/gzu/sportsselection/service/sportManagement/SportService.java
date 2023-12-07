//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.gzu.sportsselection.service.sportManagement;

import com.gzu.sportsselection.model.sportManagement.Sport;
import com.gzu.sportsselection.repository.sportManagement.SportRepository;
import java.util.List;
import java.util.Objects;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SportService {
    private final SportRepository sportRepository;

    @Autowired
    public SportService(SportRepository sportRepository) {
        this.sportRepository = sportRepository;
    }

    public void saveProperty(Sport sport) {
        this.sportRepository.save(sport);
    }

    public List<Sport> getProperties() {
        return this.sportRepository.findAll();
    }

    @Transactional
    public void update(Long id, Sport update) {
        Sport sport = (Sport)this.sportRepository.findById(id).orElseThrow(() -> {
            return new IllegalStateException("Property with id" + id + " does not exist");
        });
        if (update.getName() != null && update.getName().length() > 0 && !Objects.equals(sport.getName(), update.getName())) {
            sport.setName(update.getName());
        }

        if (update.getAddress() != null && update.getAddress().toString().length() > 0 && !Objects.equals(sport.getAddress(), update.getAddress())) {
            sport.setAddress(update.getAddress());
        }

        if (update.getStudent() != null && update.getStudent().length() > 0 && !Objects.equals(sport.getStudent(), update.getStudent())) {
            sport.setTenant(update.getStudent());
        }

        if (update.getDescription() != null && update.getDescription().length() > 0 && !Objects.equals(sport.getDescription(), update.getDescription())) {
            sport.setDescription(update.getDescription());
        }

        if (update.getPropertyType() != null && update.getPropertyType().length() > 0 && !Objects.equals(sport.getPropertyType(), update.getPropertyType())) {
            sport.setPropertyType(update.getPropertyType());
        }

        if (update.getContact() != null && !Objects.equals(sport.getContact(), update.getContact())) {
            sport.setContact(update.getContact());
        }

        if (update.getStatus() != null && update.getStatus().length() > 0 && !Objects.equals(sport.getStatus(), update.getStatus())) {
            sport.setStatus(update.getStatus());
        }

        if (update.getOwner() != null && update.getOwner().toString().length() > 0 && !Objects.equals(sport.getOwner(), update.getOwner())) {
            sport.setOwner(update.getOwner());
        }

        if (update.getAssetValue() > 0.0 && !Objects.equals(sport.getAssetValue(), update.getAssetValue())) {
            sport.setAssetValue(update.getAssetValue());
        }

        if (update.getOwner() != null && update.getOwner().toString().length() > 0 && !Objects.equals(sport.getOwner(), update.getOwner())) {
            sport.setOwner(update.getOwner());
        }

    }

    public Sport getProperty(Long id) {
        return (Sport)this.sportRepository.findById(id).orElseThrow(() -> {
            return new IllegalStateException("Property with id" + id + " does not exist");
        });
    }

    public List<Object> getPropertyIdAndName() {
        return this.sportRepository.selectNameAndID();
    }
}
