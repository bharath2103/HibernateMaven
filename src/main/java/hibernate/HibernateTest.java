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
        Integer rollNo = 1;
        Query query = session.getNamedNativeQuery("StudentRegistry.nativeByRollNo");
        query.setInteger(0,rollNo);

        List<StudentRegistry>  listOfObjects = (List<StudentRegistry>)query.list();
        session.getTransaction().commit();
        session.close();
        listOfObjects.stream().forEach(s -> System.out.println(s.getName()));

    }
}
