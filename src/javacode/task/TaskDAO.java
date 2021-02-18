package javacode.task;

import javacode.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskDAO {

    private List<Task> tasks;
    private SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Task.class)
            .buildSessionFactory();;

    public TaskDAO() {
    }


    public void saveTasksInDB(){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(tasks);
        session.getTransaction().commit();
    }

    public void getTasksFromDB(){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        tasks = session.createQuery("from Tasks").getResultList();
        session.getTransaction().commit();
    }

    public void addTask(Task task){
        tasks.add(task);
    }

    public Task getTask(int id){
        return tasks.get(id);
    }
}
