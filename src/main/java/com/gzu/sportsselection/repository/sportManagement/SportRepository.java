//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.gzu.sportsselection.repository.sportManagement;

import com.gzu.sportsselection.model.sportManagement.Sport;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SportRepository extends JpaRepository<Sport, Long> {
    @Query("SELECT s.name , s.id FROM Sport s")
    List<Object> selectNameAndID();
}
