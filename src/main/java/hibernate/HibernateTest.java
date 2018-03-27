package hibernate;


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

public class HibernateTest {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session1 = sessionFactory.openSession();
        session1.beginTransaction();
        Query query = session1.createQuery("from Vehicle");
        List<Vehicle> listOfVehicle = (List<Vehicle>) query.list();
        session1.getTransaction().commit();
        session1.close();

      listOfVehicle.forEach(l -> System.out.println(l.getVehicleName()));


    }
}
