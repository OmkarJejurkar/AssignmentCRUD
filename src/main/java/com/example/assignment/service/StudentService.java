package com.example.assignment.service;

import com.example.assignment.entity.Student;
import java.util.List;

public interface StudentService {
    public List getAllStudents();
    public Student insertNewStudent(Student student);
    public void deleteStudentById(int id);
    public Student updateStudent(Student student);
}
