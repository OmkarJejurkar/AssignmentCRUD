package com.example.assignment.controller;

import com.example.assignment.entity.Student;
import com.example.assignment.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentServiceImpl studentServiceImpl;

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents(){
     return studentServiceImpl.getAllStudents();
    }

    @DeleteMapping("deleteStudent/{id}")
    public String deleteStudent(@PathVariable int id){
        studentServiceImpl.deleteStudentById(id);
        return "Deleted Successfully";
    }

    @PostMapping("/saveStudent")
    public Student insertStudent(@RequestBody Student student){
        return studentServiceImpl.insertNewStudent(student);
    }

    @PutMapping("/updateStudent")
    public Student updateStudent(@RequestBody Student student){
        Student studentObject = studentServiceImpl.updateStudent(student);
        if(studentObject!=null) {
            return null;
        }
        else {
            return studentObject;
        }
    }

}
