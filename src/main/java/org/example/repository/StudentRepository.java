package org.example.repository;
import org.example.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class StudentRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public Student getStudentByPhoneAndName(String name, String phone) {
        String sql="select * from student where name=? and phone=?";
//        try {
//            Student student = null;
//            Connection connection = Database.getConnection();
//            PreparedStatement preparedStatement = null;
//            preparedStatement = connection.prepareStatement("select * from student where name=? and phone=?");
//            preparedStatement.setString(1, name);
//            preparedStatement.setString(2, phone);
//            ResultSet resultSet = preparedStatement.getResultSet();
//            while (resultSet.next()) {
//                student.setId(resultSet.getInt("id"));
//                student.setName(resultSet.getString("name"));
//                student.setSurname(resultSet.getString("surname"));
//                student.setPhone(resultSet.getString("phone"));
//                student.setCreatedDate(resultSet.getDate("created_date").toLocalDate());
//                student.setVisible(resultSet.getBoolean("visible"));
//                return student;
//            }
//            connection.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        return jdbcTemplate.queryForObject(sql, new Object[]{name,phone}, new BeanPropertyRowMapper<>(Student.class));
    }
    public void saveStudent(Student student) {
        String sql="insert into student (name, surname,phone) values (?,?,?)";
        int n=jdbcTemplate.update(sql,student.getName(),student.getSurname(),student.getPhone());
        System.out.println(n);
//        Connection connection = Database.getConnection();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("insert into student (name, surname,phone) values (?,?,?)");
//            preparedStatement.setString(1, student.getName());
//            preparedStatement.setString(2, student.getSurname());
//            preparedStatement.setString(3,student.getPhone());
//            preparedStatement.execute();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }
    public List<Student> getStudentList() {
        String sql="select * from student";
        List<Student> list=jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
//        try (Connection connection = Database.getConnection()) {
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("select * from student");
//            List<Student> studentList = new LinkedList<>();
//                Student student=null;
//            while (resultSet.next()) {
//                student = new Student();
//                student.setId(resultSet.getInt("id"));
//                student.setName(resultSet.getString("name"));
//                student.setSurname(resultSet.getString("surname"));
//                student.setPhone(resultSet.getString("phone"));
//                student.setCreatedDate(resultSet.getDate("created_date").toLocalDate());
//                student.setVisible(resultSet.getBoolean("visible"));
//
//                studentList.add(student);
//            }
//            return studentList;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.exit(-1);
//        }
        return list;
    }
    public void deleteStudent(Integer id) {
        String sql="delete from student where id=?";
        int n= jdbcTemplate.update(sql, id);
        System.out.println(n);
//        Connection connection = Database.getConnection();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("delete from student where id=?");
//            preparedStatement.setInt(1,id);
//            preparedStatement.execute();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }
    public static boolean isAdmin(String number, String name, String surname) {
//        Connection con = Database.getConnection();
//        try {
//            PreparedStatement preparedStatement= con.prepareStatement("select * from student where phone=? and  name=? and surname=?;");
//            preparedStatement.setString(1, number);
//            preparedStatement.setString(2, name);
//            preparedStatement.setString(3, surname);
//            ResultSet resultSet= preparedStatement.executeQuery();
//            if (resultSet.next()) {
//                return true;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        if (number.equals("123") && name.equals("Admin") && surname.equals("Admin")){
            return true;
        }
        return false;
    }
    public  boolean isRegistered(String number, String name, String surname) {
        String sql="select * from student where phone=? and  name=? and surname=?;";
        int n= jdbcTemplate.update(sql,number,name,surname);
        if(n!=0){
            return true;
        }
//        Connection con = Database.getConnection();
//        try {
//            PreparedStatement preparedStatement= con.prepareStatement("select * from student where phone=? and  name=? and surname=?;");
//            preparedStatement.setString(1, number);
//            preparedStatement.setString(2, name);
//            preparedStatement.setString(3, surname);
//            ResultSet resultSet= preparedStatement.executeQuery();
//            if (resultSet.next()) {
//                return true;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return false;
    }
    public Integer getStudentId(String phone, String name, String surname) {
        String sql="select id from student where phone=? and  name=? and surname=?;";
        int n= jdbcTemplate.update(sql,phone,name,surname);
        return n;
    }
}
