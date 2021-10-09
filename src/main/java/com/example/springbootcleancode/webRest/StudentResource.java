package com.example.springbootcleancode.webRest;

import com.example.springbootcleancode.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentResource {
    @GetMapping("/studentsAll   ")
    public ResponseEntity getAll() {
        Student student = new Student(1L, "Davron", "Sulaymonov", "3-kurs");
        Student student1 = new Student(2L, "Asilbek", "Bilmayman", "32-kurs");
        Student student2 = new Student(3L, "Javohir", "Jumayev", "31-kurs");
        Student student3 = new Student(4L, "Og'abek", "Ochilov", "33-kurs");
        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student2);
        students.add(student1);
        students.add(student3);
        return ResponseEntity.ok(students);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity getOne(@PathVariable Long id) {
        Student stud = new Student(id, "Aziz", "Azizov", "213-kurs");
        return ResponseEntity.ok(stud);
    }

    @PostMapping("/students")
    public ResponseEntity create(@RequestBody Student student) {
        return ResponseEntity.ok(student);
    }

    @GetMapping("/students")
    public ResponseEntity getOne(@RequestParam Long id,
                                 @RequestParam String name,
                                 @RequestParam String lastName,
                                 @RequestParam String course) {
        Student student = new Student(id, name, lastName, course);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return ResponseEntity.ok("Ma'lumot o'chirildi.");
    }

    @PutMapping("/students/{id}")
    public ResponseEntity update(@PathVariable Long id,
                                 @RequestBody Student studentNew) {
        Student student = new Student(1L, "Aziz", "Azizov", "213-kurs");
        student.setId(id);
        student.setName(studentNew.getName());
        student.setLastName(studentNew.getLastName());
        return ResponseEntity.ok(student);
    }

//    @GetMapping("/students")
//    public String hello(){
//        return "Hello world";
//    }

//    @RequestMapping(value = "/students", method = RequestMethod.GET)
//    public String hello(){
//        return "Hello world aaa";
//    }

}
