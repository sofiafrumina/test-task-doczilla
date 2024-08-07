package service;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Student addStudent(Student student) {
        String sql = "INSERT INTO students(name, surname, patronymic, birthdate, group_name, unique_number) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, student.getName(), student.getSurname(), student.getPatronymic(), student.getBirthdate(), student.getGroupName(), student.getUniqueNumber());
        return student;
    }

    public void deleteStudent(Long uniqueNumber) {
        String sql = "DELETE FROM students WHERE uniqueNumber = ?";
        jdbcTemplate.update(sql, uniqueNumber);
    }

    public List<Student> getAllStudents() {
        String sql = "SELECT * FROM students";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Student.class));
    }
}