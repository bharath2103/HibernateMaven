package hibernate;


import dto.UserAddress;
import dto.UserDetails;
import dto.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class HibernateTest {

    public static void main(String[] args) {
        UserDetails userDetails = new UserDetails();
        userDetails.setUserName("Aishu");

        Vehicle vehicleDetails = new Vehicle();
        vehicleDetails.setVehicleName("Car");

        userDetails.setVehicle(vehicleDetails);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(userDetails);
        session.save(vehicleDetails);
        session.getTransaction().commit();
        session.close();


        session = sessionFactory.openSession();
        session.beginTransaction();

        UserDetails userDetails1 = (UserDetails) session.get(UserDetails.class,1);
        System.out.println(userDetails1.getVehicle().getVehicleName());
        session.getTransaction().commit();
        session.close();
    }
}
