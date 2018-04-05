# HibernateMaven
Select statement can be used to select the exact column that we need , in hibernate we have to specify the member variables
of the persistant class. 
When using select clause the hibernate will return only a list of String , rather than list of persistence object.

we can also return a list of Map using the below codes

        Query query = session.createQuery("select new Map(rollNo, name)  from StudentRegistry");
        List<String>  listOfObjects = (List<String>)query.list();
        session.getTransaction().commit();
        session.close();
