//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.gzu.sportsselection.repository.sportManagement;

import com.gzu.sportsselection.model.sportManagement.Address;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<Address> findById(Long aLong);
}
