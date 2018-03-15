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

        UserAddress userHomeAddress = new UserAddress();
        userHomeAddress.setCity("Coimbatore");
        userHomeAddress.setPin("641001");
        userHomeAddress.setState("Tamilnadu");
        userHomeAddress.setStreet("Samaroa street");
        userDetails.setUserHomeAddress(userHomeAddress);

        UserAddress userOfficeAddress = new UserAddress();
        userOfficeAddress.setCity("Cochin");
        userOfficeAddress.setPin("6410");
        userOfficeAddress.setState("Kerala");
        userOfficeAddress.setStreet("IBS Road");
        userDetails.setUserOfficeAddress(userOfficeAddress);

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
        System.out.println("User name retrieved is "+userDetails.getUserName());

    }
}
