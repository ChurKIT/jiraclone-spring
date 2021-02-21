package javacode.dao;

import javacode.entity.Task;
import javacode.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskDAOImpl implements TaskDAO{

    public TaskDAOImpl() {
    }

    @Override
    public void add(Task task) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(task);
        tx1.commit();
        session.close();
    }

    @Override
    public List<Task> getAll() {
        //List<Task> tasks = (List<Task>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Task").list();

//        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
//        Transaction tx1 = session.beginTransaction();
//        List<Task> tasks = session.createQuery("from Task").getResultList();
//        tx1.commit();
//        return tasks;
        return null;
    }

    @Override
    public Task getOne(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Task task = session.get(Task.class, id);
        tx1.commit();
        return task;
    }
}
