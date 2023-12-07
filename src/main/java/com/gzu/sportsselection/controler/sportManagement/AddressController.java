//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.gzu.sportsselection.controler.sportManagement;

import com.gzu.sportsselection.model.sportManagement.Address;
import com.gzu.sportsselection.service.sportManagement.AddressService;
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
        path = {"/api/address"}
)
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    public Long saveAddress(Address address) {
        this.addressService.saveAddress(address);
        System.out.println(address);
        return address.getId();
    }

    @PutMapping({"/update-address/{id}"})
    public Address updateAddress(@PathVariable Long id, @RequestBody Address address) {
        this.addressService.update(id, address);
        return this.addressService.getAddress(id);
    }

    @GetMapping({"/get-address/{id}"})
    public Address getAddressAPI(@PathVariable Long id) {
        return this.addressService.getAddress(id);
    }

    public Address getAddress(Long address) {
        return this.addressService.getAddress(address);
    }
}
