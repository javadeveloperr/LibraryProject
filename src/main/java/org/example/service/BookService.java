package org.example.service;

import org.example.dto.Book;
import org.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void bookList(){
        List<Book> bookList = bookRepository.getBookList();
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    public void deleteBook(Integer id){
        bookRepository.deleteBook(id);
    }

    public void addBook(Book book) {
        bookRepository.saveBook(book);
    }

    public void getBookListUser() {
        List<Book> bookList = bookRepository.getBookList();
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void takenBooksUser(Integer id) {
        List<Book> bookList=bookRepository.takenBookUser(id);
        for (Book book:bookList){
            System.out.println(book);
        }
    }
}
