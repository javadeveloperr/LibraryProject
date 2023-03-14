package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.dto.Book;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Scanner;

@Component
public class BookController {
    @Autowired
    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    public BookController() {
    }

    Scanner scanner=new Scanner(System.in);
    public void getBookListAdmin(){
        System.out.println("Book List");
        bookService.bookList();
    }
    public void deleteBook(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter book id : ");
        Integer id= scanner.nextInt();
        bookService.deleteBook(id);
    }
    public void addBook(){
        System.out.println("Add Book ");
        System.out.println("Enter book title :");
        String title= scanner.next().trim();
        System.out.println("Enter book author :  ");
        String author= scanner.next().trim();
        System.out.println("Enter book publish year : ");
        String publishYear=scanner.next().trim();
        System.out.println("Enter book amount :  ");
        Integer amount= scanner.nextInt();
        Book book=new Book();
        book.setTitle(title);
        book.setAmount(amount);
        book.setAuthor(author);
        book.setPublishYear(LocalDate.parse(publishYear));
        bookService.addBook(book);
    }
    public void getBookListUser(){
        System.out.println("Book List");
        bookService.getBookListUser();
    }
    public void takenBooksUser(Integer id){
        System.out.println("Your taken books : ");
        bookService.takenBooksUser(id);
    }
}
