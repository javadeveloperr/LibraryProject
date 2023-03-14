package org.example.service;

import org.example.dto.Student;
import org.example.repository.StudentRepository;
import org.example.util.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void getStudentListAdmin() {
        List<Student> studentList = studentRepository.getStudentList();
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    public void addStudent(Student student) {
        studentRepository.saveStudent(student);
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteStudent(id);
    }

    public Integer getStudentId(String phone, String name, String surname) {
        return studentRepository.getStudentId(phone, name, surname);
    }
}
