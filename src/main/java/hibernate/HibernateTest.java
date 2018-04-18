package hibernate;


import dto.StudentMarks;
import dto.StudentRegistry;
import dto.UserAddress;
import dto.UserDetails;
import dto.Vehicle;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import javax.rmi.CORBA.StubDelegate;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class HibernateTest {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(StudentRegistry.class);
        criteria.add(Restrictions.or(Restrictions.ge("studentMarks.socialScience",90),
                Restrictions.between("studentMarks.english",40,100)));
        List<StudentRegistry>  listOfObjects = (List<StudentRegistry>)criteria.list();
        session.getTransaction().commit();
        session.close();
        listOfObjects.stream().forEach(s -> System.out.println(s.getName()));
    }
}
