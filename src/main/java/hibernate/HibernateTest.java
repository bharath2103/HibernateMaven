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

        Vehicle vehicleDetails1 = new Vehicle();
        vehicleDetails1.setVehicleName("Car");
        vehicleDetails1.setUserDetails(userDetails);
        Vehicle vehicleDetails2 = new Vehicle();
        vehicleDetails2.setVehicleName("Jeep");
        vehicleDetails2.setUserDetails(userDetails);

        userDetails.getVehicle().add(vehicleDetails1);
        userDetails.getVehicle().add(vehicleDetails2);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(userDetails);
        session.save(vehicleDetails1);
        session.save(vehicleDetails2);
        session.getTransaction().commit();
        session.close();


//        session = sessionFactory.openSession();
//        session.beginTransaction();
//
//        UserDetails userDetails1 = (UserDetails) session.get(UserDetails.class,1);
//        userDetails1.getListOfVehicle().stream()
//                .forEach(s -> System.out.println(s.getVehicleName()));
//        session.getTransaction().commit();
//        session.close();
    }
}
