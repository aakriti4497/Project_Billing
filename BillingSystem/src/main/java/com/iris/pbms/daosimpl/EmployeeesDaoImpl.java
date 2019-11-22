package com.iris.pbms.daosimpl;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.iris.pbms.daos.EmployeeesDao;
import com.iris.pbms.model.Employeees;

@Repository("employeeDao")
public class EmployeeesDaoImpl implements EmployeeesDao{

	@Autowired
    SessionFactory sessionFactory;

     public List<Employeees> getAllEmployee() {
        try {

          Session session=sessionFactory.getCurrentSession();

			Query q=session.createQuery("from com.iris.pbms.model.Employeees");

            if (q.list()!=null) {
             System.out.println("Not null");

              return q.list();
              } else {

          System.out.println("Null");
                return null;
          }
	}
             catch(Exception e)
       {

           e.printStackTrace();

}

      return null;

	}



}