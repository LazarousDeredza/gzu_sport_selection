//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.gzu.sportsselection.controler.sportManagement;

import com.gzu.sportsselection.model.sportManagement.ContactDetails;
import com.gzu.sportsselection.service.sportManagement.ContactDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(
        path = {"/api/contact-details"}
)
public class ContactDetailsController {
    private final ContactDetailsService contactDetailsService;

    @Autowired
    public ContactDetailsController(ContactDetailsService contactDetailsService) {
        this.contactDetailsService = contactDetailsService;
    }

    public Long saveContact(ContactDetails contactDetails) {
        this.contactDetailsService.saveContactDetails(contactDetails);
        return contactDetails.getId();
    }

    @PutMapping({"/update-contact-details/{id}"})
    public ContactDetails updateContactDetails(@PathVariable Long id, @RequestBody ContactDetails contactDetails) {
        return this.contactDetailsService.update(id, contactDetails);
    }

    @GetMapping({"/get-contact-details/{id}"})
    public ContactDetails getContactAPI(@PathVariable Long id) {
        return this.contactDetailsService.getContact(id);
    }

    public ContactDetails getContact(Long contactDetails) {
        return this.contactDetailsService.getContact(contactDetails);
    }
}
