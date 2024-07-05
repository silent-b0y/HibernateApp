package ru.silent_boy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.silent_boy.model.Director;
import ru.silent_boy.model.Item;
import ru.silent_boy.model.Movie;
import ru.silent_boy.model.Person;



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
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Movie movie = session.get(Movie.class, 9);
            session.remove(movie);

            session.getTransaction().commit();
        }
    }
}
