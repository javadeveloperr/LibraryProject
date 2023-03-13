package org.example.controller;

import org.example.dto.Student;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class StudentController {
    @Autowired
    StudentService studentService;
    Scanner scanner=new Scanner(System.in);

    public void studentList(){
        System.out.println("Student List");
        studentService.getStudentListAdmin();
    }
    public void addStudent(){
        System.out.println("Enter name : ");
        String name=scanner.next().trim();
        System.out.println("Enter surname : ");
        String surname=scanner.next().trim();
        System.out.println("Enter phone : ");
        String phone=scanner.next().trim();
        Student student=new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setPhone(phone);
        studentService.addStudent(student);
    }
    public void deleteStudent(){
        System.out.println("Enter student id : ");
        Integer id= scanner.nextInt();
        studentService.deleteStudent(id);
    }
}
