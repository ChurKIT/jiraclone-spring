package javacode;

import javacode.configs.SpringConfig;
import javacode.entity.Employee;
import javacode.user.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        User testUser = context.getBean("user", User.class);

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {
            for (int i = 0; i < 100; i++) {
                Session session = sessionFactory.getCurrentSession();
                Employee emp = new Employee("Alex" + i, "Chur" + i, "IT", 1000 + i);
                session.beginTransaction();
                session.save(emp);
                session.getTransaction().commit();
            }
        } catch (Exception e) {
            System.out.println("Exception in transaction");
        }
    }
}
