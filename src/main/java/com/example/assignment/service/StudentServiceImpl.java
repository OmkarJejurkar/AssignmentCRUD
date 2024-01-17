package com.example.assignment.service;

import com.example.assignment.entity.Student;
import com.example.assignment.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public List getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student insertNewStudent(Student student) {
        studentRepository.save(student);
        return student;
    }

    @Override
    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);
    }

    /**
     * updateStudent method checks given student already exists
     * or not if not returns null
     * @param student
     * @return
     */
    @Override
    public Student updateStudent(Student student) {
        int id = student.getId();
        Optional<Student> entity =studentRepository.findById(id);
        if(entity.isPresent()) {
            studentRepository.save(student);
            return student;
        }
        else{
            return null;
        }
    }
}
