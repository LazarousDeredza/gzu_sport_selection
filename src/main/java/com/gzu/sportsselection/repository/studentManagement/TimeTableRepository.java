//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.gzu.sportsselection.repository.studentManagement;

import com.gzu.sportsselection.model.sportManagement.History;
import com.gzu.sportsselection.model.sportManagement.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeTableRepository extends JpaRepository<Timetable, Long> {

}
