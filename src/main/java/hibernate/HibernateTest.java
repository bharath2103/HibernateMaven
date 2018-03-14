package hibernate;


import dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class HibernateTest {

    public static void main(String[] args) {
        UserDetails userDetails = new UserDetails();
        userDetails.setUserName("Aishu");
        userDetails.setUserAge(20);
        userDetails.setDateOfBirth(new Date());
        userDetails.setDescription("2222wsssssssssss");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(userDetails);
        session.getTransaction().commit();
        session.close();

        userDetails = null;
        session = sessionFactory.openSession();
        session.beginTransaction();
        userDetails = (UserDetails) session.get(UserDetails.class, 1);
        System.out.println("User name retreived is "+userDetails.getUserName());

    }
}
