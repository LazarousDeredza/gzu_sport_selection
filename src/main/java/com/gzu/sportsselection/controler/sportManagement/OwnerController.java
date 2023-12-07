//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.gzu.sportsselection.controler.sportManagement;

import com.gzu.sportsselection.model.sportManagement.Owner;
import com.gzu.sportsselection.service.sportManagement.OwnerService;
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
        path = {"/api/owner"}
)
public class OwnerController {
    private final OwnerService ownerService;
    private final AddressController addressController;
    private final ContactDetailsController contactDetailsController;

    @Autowired
    public OwnerController(OwnerService ownerService, AddressController addressController, ContactDetailsController contactDetailsController) {
        this.ownerService = ownerService;
        this.addressController = addressController;
        this.contactDetailsController = contactDetailsController;
    }

    public Long newOwner(Owner owner) {
        owner.setAddress(this.addressController.saveAddress(owner.getAddressObject()));
        owner.setContactDetails(this.contactDetailsController.saveContact(owner.getContactDetailsObject()));
        this.ownerService.saveOwner(owner);
        return owner.getId();
    }

    @PutMapping({"/update-owner/{id}"})
    public Owner updateOwner(@PathVariable Long id, @RequestBody Owner owner) {
        return this.ownerService.update(id, owner);
    }

    @GetMapping({"get-owner/{id}"})
    public Owner getOwnerAPI(@PathVariable Long id) {
        return this.ownerService.getOwner(id);
    }

    public Owner getOwner(Long id) {
        Owner owner = this.ownerService.getOwner(id);
        owner.setAddressObject(this.addressController.getAddress(owner.getAddress()));
        owner.setContactDetailsObject(this.contactDetailsController.getContact(owner.getContactDetails()));
        return owner;
    }
}
