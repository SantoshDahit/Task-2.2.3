package web.dao;

import web.model.Student;

import java.util.List;

public interface StudentDao {
    void addStudent(Student student);
    List<Student> getAll();

    Student getStudentById(int id);

    void updateStudentById(int id, String firstName, String lastName, String degree);

    void deleteStudentById(int id);
}
