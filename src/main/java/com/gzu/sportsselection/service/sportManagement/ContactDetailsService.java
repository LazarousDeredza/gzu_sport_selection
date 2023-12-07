//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.gzu.sportsselection.service.sportManagement;

import com.gzu.sportsselection.model.sportManagement.ContactDetails;
import com.gzu.sportsselection.repository.sportManagement.ContactRepository;
import java.util.Objects;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactDetailsService {
    private final ContactRepository contactRepository;

    @Autowired
    public ContactDetailsService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public void saveContactDetails(ContactDetails contactDetails) {
        this.contactRepository.save(contactDetails);
    }

    @Transactional
    public ContactDetails update(Long id, ContactDetails update) {
        ContactDetails contactDetails = (ContactDetails)this.contactRepository.findById(id).orElseThrow(() -> {
            return new IllegalStateException("Contact details with id: " + id + " does not exist");
        });
        if (update.getEmail() != null && update.getEmail().length() > 0 && !Objects.equals(contactDetails.getEmail(), update.getEmail())) {
            contactDetails.setEmail(update.getEmail());
        }

        if (update.getMobileNumber() != null && update.getMobileNumber().length() > 0 && !Objects.equals(contactDetails.getMobileNumber(), update.getMobileNumber())) {
            contactDetails.setMobileNumber(update.getMobileNumber());
        }

        if (update.getPhone() != null && update.getPhone().length() > 0 && !Objects.equals(contactDetails.getPhone(), update.getPhone())) {
            contactDetails.setPhone(update.getEmail());
        }

        return (ContactDetails)this.contactRepository.findById(id).orElseThrow(() -> {
            return new IllegalStateException("Contact details with id: " + id + " does not exist");
        });
    }

    public ContactDetails getContact(Long contactDetails) {
        return (ContactDetails)this.contactRepository.findById(contactDetails).orElseThrow(() -> {
            return new IllegalStateException("Contact details with id: " + contactDetails + " does not exist");
        });
    }
}
