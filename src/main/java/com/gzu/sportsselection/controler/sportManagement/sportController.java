//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.gzu.sportsselection.controler.sportManagement;

import com.gzu.sportsselection.model.sportManagement.Sport;
import com.gzu.sportsselection.service.sportManagement.SportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(
        path = {"/api/sport"}
)
public class sportController {
    private final SportService sportService;
    private final AddressController addressController;
    private final OwnerController ownerController;
    private final ContactDetailsController contactDetailsController;
    private final GroundController groundController;

    @Autowired
    public sportController(SportService sportService, AddressController addressController, OwnerController ownerController, ContactDetailsController contactDetailsController, GroundController groundController) {
        this.sportService = sportService;
        this.addressController = addressController;
        this.ownerController = ownerController;
        this.contactDetailsController = contactDetailsController;
        this.groundController = groundController;
    }

    @PostMapping({"/save-sport"})
    public Sport saveProperty(@RequestBody Sport sport) {
        sport.getAddressObject().setProperty(sport.getId());
        sport.setAddress(this.addressController.saveAddress(sport.getAddressObject()));
        sport.setOwner(this.ownerController.newOwner(sport.getOwnerObject()));
        sport.setContact(this.contactDetailsController.saveContact(sport.getPropertyContactObject()));
        this.sportService.saveProperty(sport);
        return sport;
    }

    @GetMapping({"/get-all-sports"})
    public List<Sport> getProperties() {
        List<Sport> sports = this.sportService.getProperties();

        for(int i = 0; i < sports.size(); ++i) {
            ((Sport)sports.get(i)).setAddressObject(this.addressController.getAddress(((Sport)sports.get(i)).getAddress()));
            ((Sport)sports.get(i)).setOwnerObject(this.ownerController.getOwner(((Sport)sports.get(i)).getOwner()));
            ((Sport)sports.get(i)).setPropertyContactObject(this.contactDetailsController.getContact(((Sport)sports.get(i)).getContact()));
            ((Sport)sports.get(i)).setNumberOfCompartments(this.groundController.getCompartmentsForSpecificProperty(((Sport)sports.get(i)).getId()).size());
        }

        return sports;
    }

    @GetMapping({"/get-sport/{id}"})
    public Sport getProperty(@PathVariable Long id) {
        Sport sport = this.sportService.getProperty(id);
        sport.setAddressObject(this.addressController.getAddress(sport.getAddress()));
        sport.setOwnerObject(this.ownerController.getOwner(sport.getOwner()));
        sport.setPropertyContactObject(this.contactDetailsController.getContact(sport.getContact()));
        sport.setNumberOfCompartments(this.groundController.getCompartmentsForSpecificProperty(sport.getId()).size());
        return sport;
    }

    @PutMapping({"/update-sport/{id}"})
    public Sport updateProperty(@PathVariable Long id, @RequestBody Sport sport) {
        this.sportService.update(id, sport);
        return this.sportService.getProperty(id);
    }

    @GetMapping({"/get-sport-id-and-name"})
    public List<Object> sportIdAndName() {
        return this.sportService.getPropertyIdAndName();
    }
}
