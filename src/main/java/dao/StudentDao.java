package dao;

import model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.Hibernate;

import java.util.List;

public class StudentDao {
    public void saveStudent(Student student){
        Transaction transaction = null;
        try (Session session = Hibernate.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(student);
            transaction.commit();
            session.close();
        } catch (Exception e){
            transaction.rollback();
        }
    }

    public Student getStudentById(int studentId){
        Transaction transaction = null;
        Student student = null;
        try (Session session = Hibernate.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            student = session.get(Student.class, studentId);
            transaction.commit();
            session.close();
        } catch (Exception e){
            transaction.rollback();
        }
        return student;
    }

    public List<Student> getAllStudents(){
        Transaction transaction = null;
        List<Student> students = null;
        try (Session session = Hibernate.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            students = session.createQuery("from Students").list();
            transaction.commit();
            session.close();
        } catch (Exception e){
            transaction.rollback();
        }
        return students;
    }

    public void deleteStudent(int studentId){
        Transaction transaction = null;
        Student student = null;
        try (Session session = Hibernate.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            student = session.get(Student.class, studentId);
            session.delete(student);
            transaction.commit();
            session.close();
        } catch (Exception e){
            transaction.rollback();
        }
    }
}
