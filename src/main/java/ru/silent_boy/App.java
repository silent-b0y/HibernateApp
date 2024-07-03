package ru.silent_boy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.silent_boy.model.Person;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Person persson = session.get(Person.class, 1);
            System.out.println(persson.getName());
            System.out.println(persson.getAge());
            session.getTransaction().commit();
        }
    }
}
