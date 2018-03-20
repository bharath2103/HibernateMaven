package hibernate;


import dto.FourWheelerVehicleImpl;
import dto.TwoWheelerVehicleImpl;
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

//        Vehicle vehicleDetails1 = new Vehicle();
//        vehicleDetails1.setVehicleName("Maserati");
//        vehicleDetails1.setUserID(userDetails);
//        Vehicle vehicleDetails2 = new Vehicle();
//        vehicleDetails2.setVehicleName("Bugatti");
//        vehicleDetails2.setUserID(userDetails);

        TwoWheelerVehicleImpl twoWheelerVehicle = new TwoWheelerVehicleImpl();
        twoWheelerVehicle.setVehicleName("Atlas");
        twoWheelerVehicle.setUserID(userDetails);
        twoWheelerVehicle.setSteeringBar("Atlas handle bar");

        FourWheelerVehicleImpl fourWheelerVehicle = new FourWheelerVehicleImpl();
        fourWheelerVehicle.setVehicleName("RollsRoyce");
        fourWheelerVehicle.setUserID(userDetails);
        fourWheelerVehicle.setSteeringWheel("Rolls royce steering wheel");


        userDetails.getVehicle().add(twoWheelerVehicle);
        userDetails.getVehicle().add(twoWheelerVehicle);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(userDetails);
        session.save(twoWheelerVehicle);
        session.save(fourWheelerVehicle);
        session.save(userDetails);
        session.getTransaction().commit();
        session.close();

        Session session1 = sessionFactory.openSession();
        session1.beginTransaction();
        Vehicle vehicle = session1.get(Vehicle.class,2);
        System.out.println(vehicle.getUserID());
        session1.getTransaction().commit();
        session1.close();
    }
}