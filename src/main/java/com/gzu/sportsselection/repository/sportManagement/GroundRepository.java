//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.gzu.sportsselection.repository.sportManagement;

import com.gzu.sportsselection.model.sportManagement.Ground;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GroundRepository extends JpaRepository<Ground, Long> {
    @Query("SELECT s FROM Ground  s WHERE s.property = ?1")
    List<Ground> findByProperty(Long id);

    List<Ground> findByTenant(Long id);
}
