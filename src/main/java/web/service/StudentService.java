package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import web.dao.StudentDao;
import web.model.Student;

import java.util.List;

public interface StudentService {
    void addStudent(Student student);
    List<Student> getAll();

    Student getStudentById(int id);

    void updateStudentById(int id, String firstName, String lastName, String degree);

    void deleteStudentById(int id);


}
