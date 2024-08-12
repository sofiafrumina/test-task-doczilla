package service;

import model.Student;
import org.springframework.stereotype.Service;
import java.util.List;
import repository.StudentRepository;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long uniqueNumber) {
        return studentRepository.findById(uniqueNumber).orElse(null);
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long uniqueNumber) {
        studentRepository.deleteById(uniqueNumber);
    }
}

