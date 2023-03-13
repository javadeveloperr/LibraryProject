package org.example.controller;

import org.example.service.StudentBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentBookController {
    @Autowired
    StudentBookService studentBookService;
    public void studentTakenBook(){
        studentBookService.studentTakenBook();
    }
    public void takenBookHistory(){
        studentBookService.takenBooksHistory();
    }
}
