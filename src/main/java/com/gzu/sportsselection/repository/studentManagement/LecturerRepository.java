//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.gzu.sportsselection.repository.studentManagement;

import com.gzu.sportsselection.model.studentManagement.Lecturer;
import com.gzu.sportsselection.model.studentManagement.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, Long> {
    Lecturer getByName(String name);
}
