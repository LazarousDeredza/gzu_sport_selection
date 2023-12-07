//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.gzu.sportsselection.service.sportManagement;

import com.gzu.sportsselection.model.sportManagement.Owner;
import com.gzu.sportsselection.repository.sportManagement.OwnerRepository;
import java.util.Objects;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {
    private final OwnerRepository ownerRepository;

    @Autowired
    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public void saveOwner(Owner owner) {
        this.ownerRepository.save(owner);
    }

    @Transactional
    public Owner update(Long id, Owner update) {
        Owner owner = (Owner)this.ownerRepository.findById(id).orElseThrow(() -> {
            return new IllegalStateException("Owner with id: " + id + " does not exist");
        });
        if (update.getName() != null && update.getName().length() > 0 && !Objects.equals(owner.getName(), update.getName())) {
            owner.setName(update.getName());
        }

        if (update.getLastName() != null && update.getLastName().length() > 0 && !Objects.equals(owner.getLastName(), update.getLastName())) {
            owner.setLastName(update.getLastName());
        }

        return (Owner)this.ownerRepository.findById(id).orElseThrow(() -> {
            return new IllegalStateException("Owner with id: " + id + " does not exist");
        });
    }

    public Owner getOwner(Long owner) {
        return (Owner)this.ownerRepository.findById(owner).orElseThrow(() -> {
            return new IllegalStateException("Owner with id: " + owner + " does not exist");
        });
    }
}
