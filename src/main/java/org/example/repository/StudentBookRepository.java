package org.example.repository;
import org.example.dto.Book;
import org.example.dto.StudentBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentBookRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<StudentBook> studentTakenBooksAdmin() {
        String sql = "select * from student_book where status='TAKEN'";
        List<StudentBook> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(StudentBook.class));
//        try (Connection connection = Database.getConnection()) {
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("select * from student_book where status='TAKEN'");
//            List<StudentBook> bookList = new LinkedList<>();
//            StudentBook studentBook=null;
//            while (resultSet.next()) {
//                studentBook = new StudentBook();
//                studentBook.setId(resultSet.getInt("id"));
//                studentBook.setStudent_id(resultSet.getInt("student_id"));
//                studentBook.setBook_id(resultSet.getInt("book_id"));
//                studentBook.setCreatedDate(resultSet.getDate("created_date").toLocalDate());
//                studentBook.setReturnedDate(resultSet.getDate("returned_date").toLocalDate());
//                studentBook.setStatus(Status.valueOf(resultSet.getString("status")));
//                studentBook.setDuration(Duration.ofDays(Duration.between(studentBook.getCreatedDate(), studentBook.getReturnedDate()).toDays()));
//
//                bookList.add(studentBook);
//            }
//            return bookList;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.exit(-1);
//        }
        return list;
    }

    public List<StudentBook> bookTakenHistory() {
        String sql = "select * from student_book";
        List<StudentBook> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(StudentBook.class));
//        try (Connection connection = Database.getConnection()) {
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("select * from student_book");
//            List<StudentBook> bookList = new LinkedList<>();
//            StudentBook studentBook=null;
//            while (resultSet.next()) {
//                studentBook = new StudentBook();
//                studentBook.setId(resultSet.getInt("id"));
//                studentBook.setStudent_id(resultSet.getInt("student_id"));
//                studentBook.setBook_id(resultSet.getInt("book_id"));
//                studentBook.setCreatedDate(resultSet.getDate("created_date").toLocalDate());
//                studentBook.setReturnedDate(resultSet.getDate("returned_date").toLocalDate());
//                studentBook.setStatus(Status.valueOf(resultSet.getString("status")));
//                studentBook.setDuration(Duration.ofDays(Duration.between(studentBook.getCreatedDate(), studentBook.getReturnedDate()).toDays()));
//
//                bookList.add(studentBook);
//            }
//            return bookList;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.exit(-1);
//        }
        return null;
    }

    public List<Book> getStudentBookList(Integer studentId) {
        String sql="select * from student_book where student_id="+String.valueOf(studentId);
        List<Book> list=jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
//        try (Connection connection = Database.getConnection()) {
//            PreparedStatement preparedStatement = connection.prepareStatement("select * from student_book where student_id=?");
//            preparedStatement.setInt(1, studentId);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            List<Book> bookList = new LinkedList<>();
//            Book book = null;
//            while (resultSet.next()) {
//                book = new Book();
//                book.setId(resultSet.getInt("id"));
//                book.setTitle(resultSet.getString("title"));
//                book.setAuthor(resultSet.getString("author"));
//                book.setAmount(resultSet.getInt("amount"));
//                book.setPublishYear(resultSet.getDate("publish_year").toLocalDate());
//                book.setVisible(resultSet.getBoolean("visible"));
//                bookList.add(book);
//            }
//            return bookList;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.exit(-1);
//        }
        return list;
    }

    public List<Book> studentTakenBook(Integer studentId) {
        String sql="select * from student_book where student_id="+String.valueOf(studentId) +"and status='TAKEN'";
        List<Book> list=jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
//        try (Connection connection = Database.getConnection()) {
//            PreparedStatement preparedStatement = connection.prepareStatement("select * from student_book where student_id=? and status='TAKEN'");
//            preparedStatement.setInt(1, studentId);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            List<Book> bookList = new LinkedList<>();
//            Book book = null;
//            while (resultSet.next()) {
//                book = new Book();
//                book.setId(resultSet.getInt("id"));
//                book.setTitle(resultSet.getString("title"));
//                book.setAuthor(resultSet.getString("author"));
//                book.setAmount(resultSet.getInt("amount"));
//                book.setPublishYear(resultSet.getDate("publish_year").toLocalDate());
//                book.setVisible(resultSet.getBoolean("visible"));
//                bookList.add(book);
//            }
//            return bookList;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.exit(-1);
//        }
        return list;
    }
}
