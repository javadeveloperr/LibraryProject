package org.example.repository;

import org.example.db.Database;
import org.example.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
@Component
public class StudentRepository {
    public Student getStudentByPhoneAndName(String name, String phone) {
        try {
            Student student = null;
            Connection connection = Database.getConnection();
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement("select * from student where name=? and phone=?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phone);
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setPhone(resultSet.getString("phone"));
                student.setCreatedDate(resultSet.getDate("created_date").toLocalDate());
                student.setVisible(resultSet.getBoolean("visible"));
                return student;
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public void saveStudent(Student student) {
        Connection connection = Database.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into student (name, surname,phone) values (?,?,?)");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurname());
            preparedStatement.setString(3,student.getPhone());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Student> getStudentList() {
        try (Connection connection = Database.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student");
            List<Student> studentList = new LinkedList<>();
                Student student=null;
            while (resultSet.next()) {
                student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setPhone(resultSet.getString("phone"));
                student.setCreatedDate(resultSet.getDate("created_date").toLocalDate());
                student.setVisible(resultSet.getBoolean("visible"));

                studentList.add(student);
            }
            return studentList;
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return null;
    }
    public void deleteStudent(Integer id) {
        Connection connection = Database.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from student where id=?");
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
    public static boolean isRegistered(String number, String name, String surname) {
        Connection con = Database.getConnection();
        try {
            PreparedStatement preparedStatement= con.prepareStatement("select * from student where phone=? and  name=? and surname=?;");
            preparedStatement.setString(1, number);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, surname);
            ResultSet resultSet= preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
