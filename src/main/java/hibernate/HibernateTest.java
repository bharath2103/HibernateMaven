package hibernate;


import dto.UserAddress;
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
        userDetails.setDescription("She's my queen");

        UserAddress userAddress1 = new UserAddress();
        userAddress1.setCity("Coimbatore");
        userAddress1.setPin("641001");
        userAddress1.setState("Tamilnadu");
        userAddress1.setStreet("Samaroa street");

        UserAddress userAddress2 = new UserAddress();
        userAddress2.setCity("Cochin");
        userAddress2.setPin("6410");
        userAddress2.setState("Kerala");
        userAddress2.setStreet("IBS Road");


        userDetails.getListOfUserAddress().add(userAddress1);
        userDetails.getListOfUserAddress().add(userAddress2);

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
        System.out.println("User name retrieved is "+userDetails.getListOfUserAddress());

    }
}
