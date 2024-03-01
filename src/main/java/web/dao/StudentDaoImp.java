package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import web.model.Student;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class StudentDaoImp implements StudentDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void addStudent(Student student) {
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Student> getAll() {
        entityManager.getTransaction().begin();
        List<Student> listStudent = entityManager.createQuery("FROM Student").getResultList();
        entityManager.getTransaction().commit();
        return listStudent;

    }

    @Override
    public Student getStudentById(int id) {
        entityManager.getTransaction().begin();
        Student studentById = entityManager.find(Student.class, id);
        entityManager.getTransaction().commit();
        return studentById;
    }

    @Override
    public void updateStudentById(int id, String updateFirstName, String updateLastName, String updatedDegree) {
        entityManager.getTransaction().begin();
        Student updateStudent = entityManager.find(Student.class, id);
        updateStudent.setFirstName(updateFirstName);
        updateStudent.setLastName(updateLastName);
        updateStudent.setDegree(updatedDegree);

        // You can use JPQL or native SQL for updates, choose one
        String updateQuery = "UPDATE Student SET firstName = :newFirstName, lastName = :newLastName, degree = :newDegree WHERE id = :id";
        entityManager.createQuery(updateQuery)
                .setParameter("id", id)
                .setParameter("newFirstName", updateStudent.getFirstName())
                .setParameter("newLastName", updateStudent.getLastName())
                .setParameter("newDegree", updateStudent.getDegree())
                .executeUpdate();
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteStudentById(int id) {
        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM Student WHERE id = :id")
                .setParameter("id", id)
                .executeUpdate();
        entityManager.getTransaction().commit();
    }
}
