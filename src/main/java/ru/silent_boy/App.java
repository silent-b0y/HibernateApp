package ru.silent_boy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.silent_boy.model.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Configuration configuration = new Configuration().addAnnotatedClass(Director.class);
        configuration.addAnnotatedClass(Movie.class);
        configuration.addAnnotatedClass(Person.class);
        configuration.addAnnotatedClass(Item.class);
        configuration.addAnnotatedClass(Passport.class);
        configuration.addAnnotatedClass(Principal.class);
        configuration.addAnnotatedClass(School.class);
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();



            session.getTransaction().commit();
        }
    }
}
