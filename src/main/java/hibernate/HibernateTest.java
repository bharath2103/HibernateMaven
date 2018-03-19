package hibernate;


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
        vehicleDetails1.setVehicleName("Maserati");
//        vehicleDetails1.setUserID(userDetails);
        Vehicle vehicleDetails2 = new Vehicle();
        vehicleDetails2.setVehicleName("Bugatti");
 //       vehicleDetails2.setUserID(userDetails);


        userDetails.getVehicle().add(vehicleDetails1);
        userDetails.getVehicle().add(vehicleDetails2);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(userDetails);
 //       session.save(vehicleDetails1);
 //       session.save(vehicleDetails2);
        session.getTransaction().commit();
        session.close();


        Session session1 = sessionFactory.openSession();
        session1.beginTransaction();
        Vehicle vehicle = (Vehicle)session1.get(Vehicle.class,2);
        System.out.println(vehicle.getUserID());
        session1.getTransaction().commit();
        session1.close();


    }
}