package org.example.repository;

import org.example.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class BookRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Book getBookByName(String name) {
        String sql="select * from book where name=? and visible=true";

//        try {
//            Book book = new Book();
//            Connection connection = Database.getConnection();
//            PreparedStatement preparedStatement = null;
//            preparedStatement = connection.prepareStatement("select * from book where name=? and visible=true");
//            preparedStatement.setString(1, name);
//            ResultSet resultSet = preparedStatement.getResultSet();
//            while (resultSet.next()) {
//                book.setId(resultSet.getInt("id"));
//                book.setTitle(resultSet.getString("title"));
//                book.setAuthor(resultSet.getString("author"));
//                book.setAmount(resultSet.getInt("amount"));
//                return book;
//            }
//            connection.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        return jdbcTemplate.queryForObject(sql, new Object[]{name}, new BeanPropertyRowMapper<>(Book.class));
    }
    public void saveBook(Book book) {
        String sql= "insert into book (title, author,amount, publish_year) values (?,?,?,?)";
        int n=jdbcTemplate.update(sql,book.getTitle(), book.getAuthor(), book.getAmount(), book.getPublishYear());
        System.out.println(n);
//        Connection connection = Database.getConnection();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(
//                    "insert into book (title, author,amount, publish_year) values (?,?,?,?)");
//            preparedStatement.setString(1, book.getTitle());
//            preparedStatement.setString(2, book.getAuthor());
//            preparedStatement.setInt(3, book.getAmount());
//            preparedStatement.setDate(4, Date.valueOf(book.getPublishYear()));
//            preparedStatement.execute();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }

    public List<Book> getBookList() {
        String sql="select * from book";
        List<Book> list=jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
//        try (Connection connection = Database.getConnection()) {
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("select * from book");
//            List<Book> bookList = new LinkedList<>();
//            Book book=null;
//            while (resultSet.next()) {
//                book = new Book();
//                book.setId(resultSet.getInt("id"));
//                book.setTitle(resultSet.getString("title"));
//                book.setAuthor(resultSet.getString("author"));
//                book.setAmount(resultSet.getInt("amount"));
//                book.setPublishYear(resultSet.getDate("publish_year").toLocalDate());
//                book.setVisible(resultSet.getBoolean("visible"));
//
//                bookList.add(book);
//            }
//            return bookList;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.exit(-1);
//        }
        return list;
    }
    public void deleteBook(Integer id) {
        String sql="delete from book where id=?";
        int n=jdbcTemplate.update(sql,id);
        System.out.println(n);
//        Connection connection = Database.getConnection();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("delete from book where id=?");
//            preparedStatement.setInt(1, id);
//            preparedStatement.execute();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }

    public List<Book> takenBookUser(Integer id) {
        String sql="select title, author, publish_year from" +
                " book where id in (select book_id from student_book where student_id=?)";
        List<Book> list=jdbcTemplate.query(sql,new Object[]{id},new BeanPropertyRowMapper<>(Book.class));
        return list;
    }
    public Integer getBookIdWithName(String title){
        String sql="select id from book where title=?";
        Integer id=jdbcTemplate.update(sql,Integer.class);
        if (id==null){
            return -1;
        }
        return id;
    }
    public boolean checkBookAvailable(Integer id){
        String sql="select * from book where id=? and amount>=1";
        int n=jdbcTemplate.update(sql,new Object[]{id});
        if (n>=1){
            return true;
        }
        return false;
    }
}
