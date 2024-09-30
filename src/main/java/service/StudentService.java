package service;

import db.Database;
import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentService {

    // Получение всех студентов
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM students")) {

            while (resultSet.next()) {
                Student student = new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("patronymic"),
                        resultSet.getString("group"),
                        resultSet.getString("birth_date")
                );
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    // Добавление студента
    public void addStudent(Student student) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO students (first_name, last_name, patronymic, group, birth_date) VALUES (?, ?, ?, ?, ?)")) {

            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setString(3, student.getPatronymic());
            preparedStatement.setString(4, student.getGroup());
            preparedStatement.setString(5, student.getBirthDate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Удаление студента по ID
    public void deleteStudent(int id) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM students WHERE id = ?")) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
