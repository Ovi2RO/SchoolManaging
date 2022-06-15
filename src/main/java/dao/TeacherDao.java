package dao;

import model.Teacher;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.Hibernate;

import java.util.List;

public class TeacherDao {
    public void saveTeacher(Teacher teacher){
        Transaction transaction = null;
        try (Session session = Hibernate.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(teacher);
            transaction.commit();
            session.close();
        } catch (Exception e){
            transaction.rollback();
        }
    }

    public void deleteTeacher(int teacherId){
        Transaction transaction = null;
        Teacher teacher = null;
        try (Session session = Hibernate.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            teacher = session.get(Teacher.class, teacherId);
            session.delete(teacher);
            transaction.commit();
            session.close();
        } catch (Exception e){
            transaction.rollback();
        }
    }

    public Teacher getTeacherById(int teacherId){
        Transaction transaction = null;
        Teacher teacher = null;
        try (Session session = Hibernate.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            teacher = session.get(Teacher.class, teacherId);
            transaction.commit();
            session.close();
        } catch (Exception e){
            transaction.rollback();
        }
        return teacher;
    }

    public List<Teacher> getTeacherList(){
        Transaction transaction = null;
        List<Teacher> teachers = null;
        try (Session session = Hibernate.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            teachers = session.createQuery("from Teachers").list();
            transaction.commit();
            session.close();
        } catch (Exception e){
            transaction.rollback();
        }
        return teachers;
    }
}
