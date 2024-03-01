package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.StudentDao;
import web.model.Student;

import java.util.List;

@Service
@Transactional
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public void addStudent(Student student) {
        studentDao.addStudent(student);

    }

    @Override
    public List<Student> getAll() {
        return studentDao.getAll();
    }

    @Override
    public Student getStudentById(int id) {
        return studentDao.getStudentById(id);
    }

    @Override
    public void updateStudentById(int id, String firstName, String lastName, String degree) {
        studentDao.updateStudentById(id, firstName, lastName, degree);
    }

    @Override
    public void deleteStudentById(int id) {
        studentDao.deleteStudentById(id);

    }
}
