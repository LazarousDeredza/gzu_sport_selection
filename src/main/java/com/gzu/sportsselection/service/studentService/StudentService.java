//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.gzu.sportsselection.service.studentService;

import com.gzu.sportsselection.model.sportManagement.Sport;
import com.gzu.sportsselection.model.studentManagement.Student;
import com.gzu.sportsselection.repository.leaseManagement.LeaseRepository;
import com.gzu.sportsselection.repository.sportManagement.SportRepository;
import com.gzu.sportsselection.repository.studentManagement.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    private LeaseRepository leaseRepository;
    private SportRepository sportRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, LeaseRepository leaseRepository, SportRepository sportRepository) {
        this.studentRepository = studentRepository;
        this.leaseRepository = leaseRepository;
        this.sportRepository = sportRepository;
    }

    public Student addStudent(Student student) {
        return (Student)this.studentRepository.save(student);
    }

    public List<Student> addStudents(List<Student> students) {
        return this.studentRepository.saveAll(students);
    }

    public String updateStudent(Long id, Student student) {
        Student existing_student = (Student)this.studentRepository.getById(id);
        existing_student.setPhone(student.getPhone());
        existing_student.setName(student.getName());
        existing_student.setProperty(student.getProperty());
        existing_student.setId_passport(student.getId_passport());
        this.studentRepository.save(existing_student);
        return "Tenant updated successfully";
    }

    public List<Student> getAll() {
        return this.studentRepository.findAll();
    }

    public List<Student> getAllTenants() {
        return this.studentRepository.findAll();
    }

    public List< Student> getStudentsBySport(String name) {
        List<Student> students=new ArrayList<>();

        List<Student> existing_student =studentRepository.findAll();

        for (Student s:existing_student){
            if (s.getProperty().equals(name)){
                students.add(s);
            }
        }

        return students;
    }

    public Student getStudentById(Student student, Long id) {
        Student existing_student = (Student)this.studentRepository.getById(id);
        return existing_student;
    }

    public Student getStudentByID(Long id) {
        return (Student)this.studentRepository.findById(id).orElseThrow(() -> {
            return new IllegalStateException("Tenant With ID " + id + " Does Not Exist");
        });
    }

    public Student getStudentByName(Student student, String name) {
        Student existing_student = this.studentRepository.getByName(name);
        return existing_student;
    }

    public Student getStudent(Long id) {
        return (Student)this.studentRepository.findById(id).orElseThrow(() -> {
            return new IllegalStateException("Tenant with id" + id + " does not exist");
        });
    }

    public String updateStudentSport(Long id, Long sportId) {
        Student existing_student = (Student)this.studentRepository.getById(id);

        Sport sport= sportRepository.getById(sportId);
        existing_student.setProperty(sport.getName());
        this.studentRepository.save(existing_student);
        return "Student updated successfully";
    }
}
