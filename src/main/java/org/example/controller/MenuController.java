package org.example.controller;

import org.example.repository.StudentRepository;
import org.example.util.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class MenuController {
@Autowired
      StudentRepository studentRepository;
@Autowired
 BookController bookController;
@Autowired
      StudentBookController studentBookController;
@Autowired
  StudentController studentController;

//    public MenuController(StudentRepository studentRepository, BookController bookController, StudentBookController studentBookController, StudentController studentController) {
//        this.studentRepository = studentRepository;
//        this.bookController = bookController;
//        this.studentBookController = studentBookController;
//        this.studentController = studentController;
//    }

    public static Integer action() {
        System.out.println("Select menu : ");
        return ScannerUtil.IntScanner.nextInt();
    }

    public void userMenu() {
        System.out.println("1. Book List\n+" +
                "2. Take book\n" +
                "3. Taken books\n" +
                "4. Return book\n" +
                "5. History\n" +
                "6. Order book\n" +
                "0. Exit \n");
        Boolean b = true;
        while (b) {
            int action;
            action = action();
            switch (action) {
//                case 1 -> bookController.;
//                case 2 -> bookController.addBook();
//                case 3 -> bookController.deleteBook();
//                case 4 -> studentController.studentList();
//                case 5 -> studentController.addStudent();A
//                case 6 -> studentController.deleteStudent();
//                case 7 -> studentBookController.studentTakenBook();
//                case 8 -> studentBookController.takenBookHistory();
                case 0 -> b = false;
            }
        }
    }

    public void adminMenu() {
        System.out.println("1. Book list\n+" +
                "2. Add book\n" +
                "3. Delete book\n" +
                "4. Student List\n" +
                "5. Add Student\n" +
                "6. Delete student\n" +
                "7. Student Taken book\n+" +
                "8. BookTaken History\n");
        Boolean b = true;
        while (b) {
            int action;
            action = action();
            switch (action) {
                case 1 -> bookController.getBookListAdmin();
                case 2 -> bookController.addBook();
                case 3 -> bookController.deleteBook();
                case 4 -> studentController.studentList();
                case 5 -> studentController.addStudent();
                case 6 -> studentController.deleteStudent();
                case 7 -> studentBookController.studentTakenBook();
                case 8 -> studentBookController.takenBookHistory();
                case 0 -> b = false;
            }
        }
    }

    private void logIn() {
        System.out.println("Enter phone : ");
        String phone = ScannerUtil.StringScanner.next().trim();
        System.out.println("Enter name : ");
        String name = ScannerUtil.StringScanner.next().trim();
        System.out.println("Enter surname : ");
        String surname = ScannerUtil.StringScanner.next().trim();
        if (studentRepository.isAdmin(phone, name, surname)) {
            adminMenu();
        } else if (studentRepository.isRegistered(phone, name, surname)) {
            userMenu();
        } else {
            System.out.println("You may say to admin for using system");
        }
    }

    public void mainMenu() {
        System.out.println("***   Menu   ***");
        System.out.println("1. Log In");
        System.out.println("0. Exit");
        boolean b = true;
        while (b) {
            int action = action();
            switch (action) {
                case 1 -> logIn();
                case 0 -> {
                    b = false;
                    break;
                }
                default -> System.out.println("Mazgi  select menu");
            }
        }
    }
}
