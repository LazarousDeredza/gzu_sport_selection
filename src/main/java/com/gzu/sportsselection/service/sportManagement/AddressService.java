//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.gzu.sportsselection.service.sportManagement;

import com.gzu.sportsselection.model.sportManagement.Address;
import com.gzu.sportsselection.repository.sportManagement.AddressRepository;
import java.util.Objects;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public void saveAddress(Address address) {
        this.addressRepository.save(address);
    }

    @Transactional
    public void update(Long id, Address update) {
        Address address = (Address)this.addressRepository.findById(id).orElseThrow(() -> {
            return new IllegalStateException("Addresss with id: " + id + " does not exist");
        });
        if (update.getName() != null && update.getName().length() > 0 && !Objects.equals(address.getName(), update.getName())) {
            address.setName(update.getAddress());
        }

        if (update.getAddress() != null && update.getAddress().length() > 0 && !Objects.equals(address.getAddress(), update.getAddress())) {
            address.setAddress(update.getAddress());
        }

        if (update.getCity() != null && update.getCity().length() > 0 && !Objects.equals(address.getCity(), update.getCity())) {
            address.setCity(update.getCity());
        }

        if (update.getZipCode() != null && update.getZipCode().length() > 0 && !Objects.equals(address.getZipCode(), update.getZipCode())) {
            address.setZipCode(update.getZipCode());
        }

        if (update.getCountry() != null && update.getCountry().length() > 0 && !Objects.equals(address.getCountry(), update.getCountry())) {
            address.setCountry(update.getCountry());
        }

    }

    public Address getAddress(Long address) {
        return (Address)this.addressRepository.findById(address).orElseThrow(() -> {
            return new IllegalStateException("Addresss with id: " + address + " does not exist");
        });
    }
}
