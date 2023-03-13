package org.example.db;

import org.example.dto.Student;
import org.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    @Autowired
    static StudentRepository studentRepository;

    public static Connection getConnection() {
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/computer", "postgres", "root123");
            return con;
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
            e.printStackTrace();
            System.exit(-1);
        }
        return null;

    }

    private static void execute(String sql) {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void initTable() {
        String book = "create table if not exists book (" +
                "id serial primary key," +
                "title varchar(50) unique not null," +
                "author varchar(30) not null," +
                "publish_year date not null," +
                "amount int not null default 1," +
                "visible boolean not null default true);";

        String student = "create table if not exists student (" +
                "id serial primary key," +
                "name varchar(20) not null," +
                "surname varchar(20) not null," +
                "phone varchar(13) not null," +
                "created_date date not null default now()," +
                "visible boolean not null default true);";

        String studentBook = "create table if not exists student_book (" +
                "id serial primary key," +
                "student_id integer not null," +
                "book_id integer not null," +
                "created_date date not null default now()," +
                "status varchar(10) not null default 'TAKEN'," +
                "returned_date date," +
                "duration integer," +
                "foreign key(student_id) references student(id)," +
                "foreign key(book_id) references book(id));";
        execute(book);
        execute(student);
        execute(studentBook);
    }

    public static void initAdmin() {
        Student admin = new Student();
        admin.setName("Admin");
        admin.setSurname("Admin");
        admin.setPhone("123");
    }
}
