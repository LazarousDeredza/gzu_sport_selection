//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.gzu.sportsselection.controler.sportManagement;

import com.gzu.sportsselection.model.sportManagement.Ground;
import com.gzu.sportsselection.model.studentManagement.Student;
import com.gzu.sportsselection.service.sportManagement.GroundService;
import com.gzu.sportsselection.service.studentService.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(
        path = {"/api/ground2"}
)
public class GroundController2 {
    private GroundService groundService;
    private StudentService studentService;

    @Autowired
    public GroundController2(GroundService groundService, StudentService studentService) {
        this.groundService = groundService;
        this.studentService = studentService;
    }

    public List<Ground> getCompartmentsForSpecificTenant(Long id) {
        return this.groundService.getCompartmentsForSpecificTenant(id);
    }

    public Student getStudentForSpecificLease(int tenant_id) {
        return this.studentService.getStudentByID(Long.parseLong(String.valueOf(tenant_id)));
    }
}
