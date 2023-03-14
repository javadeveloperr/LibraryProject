package org.example.repository;

import org.example.db.Database;
import org.example.dto.Book;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
@Component
public class BookRepository {

    public Book getBookByName(String name) {
        try {
            Book book = new Book();
            Connection connection = Database.getConnection();
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement("select * from book where name=? and visible=true");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
                book.setAmount(resultSet.getInt("amount"));
                return book;
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public void saveBook(Book book) {
        Connection connection = Database.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into book (title, author,amount, publish_year) values (?,?,?,?)");
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setInt(3, book.getAmount());
            preparedStatement.setDate(4, Date.valueOf(book.getPublishYear()));
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Book> getBookList() {
        try (Connection connection = Database.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from book");
            List<Book> bookList = new LinkedList<>();
            Book book=null;
            while (resultSet.next()) {
                book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
                book.setAmount(resultSet.getInt("amount"));
                book.setPublishYear(resultSet.getDate("publish_year").toLocalDate());
                book.setVisible(resultSet.getBoolean("visible"));

                bookList.add(book);
            }
            return bookList;
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return null;
    }
    public void deleteBook(Integer id) {
        Connection connection = Database.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from book where id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
