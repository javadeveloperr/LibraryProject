package org.example.service;

import org.example.repository.StudentBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentBookService {
    @Autowired
    StudentBookRepository studentBookRepository;

    public void studentTakenBook() {
            studentBookRepository.studentTakenBooksAdmin();
    }
    public void takenBooksHistory(){
        studentBookRepository.bookTakenHistory();
    }
}
