package com.example.demo.controller;

import java.util.Optional;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.Student;
import com.example.demo.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api") // ✅ FIXED: Added this to match security config
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/test")
    public String listOfStudent() {
        return studentService.test();
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/students")
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    @PostMapping("/add")
    public ResponseEntity<Student> addDummyStudent(@Valid @RequestBody Student student) {
        return ResponseEntity.ok(studentService.addStudentEntry(student));
    }

    @PutMapping("/student/{id}") // ✅ FIXED: Added missing slash
    public ResponseEntity<Student> updateRecords(@Valid @PathVariable int id, @RequestBody Student student) {
        return ResponseEntity.ok(studentService.updateStudent(id, student));
    }

    @DeleteMapping("/student/{id}") // ✅ FIXED: Added missing slash
    public String deleteData(@PathVariable int id) {
        return studentService.removeData(id);
    }
}