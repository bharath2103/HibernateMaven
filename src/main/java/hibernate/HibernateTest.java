package hibernate;


import dto.StudentMarks;
import dto.StudentRegistry;
import dto.UserAddress;
import dto.UserDetails;
import dto.Vehicle;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class HibernateTest {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("select rollNo, name  from StudentRegistry");
        List<String>  listOfObjects = (List<String>)query.list();
        session.getTransaction().commit();
        session.close();

        System.out.println(listOfObjects.size());


    }
}
