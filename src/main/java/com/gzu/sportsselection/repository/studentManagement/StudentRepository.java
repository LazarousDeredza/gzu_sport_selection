//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.gzu.sportsselection.repository.studentManagement;

import com.gzu.sportsselection.model.studentManagement.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student getByName(String name);

    Student getStudentByProperty(String property);
    Student getStudentsByProperty(String property);
}
