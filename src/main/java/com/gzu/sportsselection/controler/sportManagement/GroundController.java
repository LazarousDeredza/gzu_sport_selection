//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.gzu.sportsselection.controler.sportManagement;

import com.gzu.sportsselection.controler.leaseManagement.LeaseController;
import com.gzu.sportsselection.controler.studentManagement.StudentController;
import com.gzu.sportsselection.model.sportManagement.Ground;
import com.gzu.sportsselection.service.sportManagement.GroundService;
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
        path = {"/api/ground"}
)
public class GroundController {
    GroundService groundService;
    StudentController studentController;
    LeaseController leaseController;

    @Autowired
    public GroundController(GroundService groundService, StudentController studentController, LeaseController leaseController) {
        this.groundService = groundService;
        this.studentController = studentController;
        this.leaseController = leaseController;
    }

    @PostMapping({"/save-ground"})
    public Ground saveCompartment(@RequestBody Ground ground) {
        return this.groundService.save(ground);
    }

    @GetMapping({"/get-grounds"})
    public List<Ground> getCompartments() {
        List<Ground> grounds = this.groundService.getCompartments();

        for(int i = 0; i < grounds.size(); ++i) {
            if (((Ground) grounds.get(i)).getStudent() != null) {
                ((Ground) grounds.get(i)).setTenantObject(this.studentController.getStudent(((Ground) grounds.get(i)).getStudent()));
            }
        }

        return grounds;
    }

    @GetMapping({"/get-grounds-for-specific-sport/{id}"})
    public List<Ground> getCompartmentsForSpecificPropertyApi(@PathVariable Long id) {
        List<Ground> grounds = this.groundService.getCompartmentsForSpecificProperty(id);

        for(int i = 0; i < grounds.size(); ++i) {
            if (((Ground) grounds.get(i)).getStudent() != null) {
                ((Ground) grounds.get(i)).setTenantObject(this.studentController.getStudent(((Ground) grounds.get(i)).getStudent()));
            }
        }

        return grounds;
    }

    public List<Ground> getCompartmentsForSpecificProperty(Long id) {
        List<Ground> grounds = this.groundService.getCompartmentsForSpecificProperty(id);

        for(int i = 0; i < grounds.size(); ++i) {
            if (((Ground) grounds.get(i)).getStudent() != null) {
                ((Ground) grounds.get(i)).setTenantObject(this.studentController.getStudent(((Ground) grounds.get(i)).getStudent()));
            }
        }

        return grounds;
    }

    @GetMapping({"/get-ground/{id}"})
    public Ground getCompartmentSpecificCompartment(@PathVariable Long id) {
        Ground ground = this.groundService.getCompartment(id);
        if (ground.getStudent() != null) {
            ground.setTenantObject(this.studentController.getStudent(ground.getStudent()));
        }

        return ground;
    }

    public Ground getCompartment(Long id) {
        Ground ground = this.groundService.getCompartment(id);
        if (ground.getStudent() != null) {
            ground.setTenantObject(this.studentController.getStudent(ground.getStudent()));
        }

        return ground;
    }

    @PutMapping({"/update-ground/{id}"})
    public Ground updateCompartment(@PathVariable Long id, @RequestBody Ground ground) {
        return this.groundService.update(id, ground);
    }
}
