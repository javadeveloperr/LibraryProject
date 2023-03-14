package org.example.service;

import org.example.repository.StudentBookRepository;
import org.springframework.stereotype.Component;

@Component
public class StudentBookService {

    private final StudentBookRepository studentBookRepository;

    public StudentBookService(StudentBookRepository studentBookRepository) {
        this.studentBookRepository = studentBookRepository;
    }

    public void studentTakenBook() {
            studentBookRepository.studentTakenBooksAdmin();
    }
    public void takenBooksHistory(){
        studentBookRepository.bookTakenHistory();
    }


}
