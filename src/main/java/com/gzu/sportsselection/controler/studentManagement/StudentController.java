//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.gzu.sportsselection.controler.studentManagement;

import com.gzu.sportsselection.controler.sportManagement.GroundController2;
import com.gzu.sportsselection.model.studentManagement.Student;
import com.gzu.sportsselection.repository.leaseManagement.LeaseRepository;
import com.gzu.sportsselection.service.studentService.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/students"})
public class StudentController {
    @Autowired
    private StudentService studentService;
    private LeaseRepository leaseRepository;
    private GroundController2 compartmentController;

    @Autowired
    public StudentController(StudentService studentService, GroundController2 compartmentController) {
        this.studentService = studentService;
        this.compartmentController = compartmentController;
    }

    @GetMapping({"/get-all-students"})
    public List<Student> getStudents() {
        List<Student> students = this.studentService.getAllTenants();

        for(int i = 0; i < students.size(); ++i) {
            ((Student) students.get(i)).setCompartmentObjectlist(this.compartmentController.getCompartmentsForSpecificTenant(((Student) students.get(i)).getId()));
        }

        return students;
    }

    @GetMapping({"/get-all-students-by-sport/{sportname}"})
    public List<Student> getStudentsBySport(@PathVariable String sportname) {
        List<Student> students = this.studentService.getStudentsBySport(sportname);

        for(int i = 0; i < students.size(); ++i) {
            ((Student) students.get(i)).setCompartmentObjectlist(this.compartmentController.getCompartmentsForSpecificTenant(((Student) students.get(i)).getId()));
        }

        return students;
    }


    @PostMapping({"/addStudent"})
    public Student addStudent(@RequestBody Student student) {
        return this.studentService.addStudent(student);
    }

    @PostMapping({"/addStudents"})
    public List<Student> addStudents(@RequestBody List<Student> students) {
        return this.studentService.addStudents(students);
    }

    @PutMapping({"/updateStudent/{id}"})
    public String updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return this.studentService.updateStudent(id, student);
    }

    @PutMapping({"/updateStudentSport/{id}/{sport_id}"})
    public String updateStudentSport(@PathVariable Long id, @PathVariable Long sport_id) {
        return this.studentService.updateStudentSport(id,sport_id);
    }

    @GetMapping({"/getStudent/{id}"})
    public Student getStudentById(@RequestBody Student student, @PathVariable Long id) {
        return this.studentService.getStudentById(student, id);
    }

    @GetMapping({"/getStudentByID/{id}"})
    public Student getStudentByID(@PathVariable Long id) {
        Student student = this.studentService.getStudentByID(id);
        student.setCompartmentObjectlist(this.compartmentController.getCompartmentsForSpecificTenant(student.getId()));
        return student;
    }

    public Student getStudent(Long id) {
        return this.studentService.getStudent(id);
    }

    @GetMapping({"/getStudent/{name}"})
    public Student getStudentByName(@RequestBody Student student, @PathVariable String name) {
        return this.studentService.getStudentByName(student, name);
    }
}
