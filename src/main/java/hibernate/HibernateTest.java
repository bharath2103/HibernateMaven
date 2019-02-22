package hibernate;


import dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

    public static void main(String[] args) {
        UserDetails userDetails1 = new UserDetails();
        userDetails1.setUserName("Bharath");
        userDetails1.setAadhar(111);

        UserDetails userDetails2 = new UserDetails();
        userDetails2.setUserName("Vinod");
        userDetails2.setAadhar(222);

        UserDetails userDetails3 = new UserDetails();
        userDetails3.setUserName("Amala");
        userDetails3.setAadhar(333);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(userDetails1);
        session.save(userDetails2);
        session.save(userDetails3);
        session.getTransaction().commit();
    }
}
