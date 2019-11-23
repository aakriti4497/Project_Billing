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

     public List<Employeees> getAllEmployeees() {
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



/*
	
	public List<Employeees> employeeAllocation(int employeeId) {
        try {
             Session session=sessionFactory.getCurrentSession();
             Query q=session.createQuery("from com.iris.pbms.model.Employeees where employeeId=:employeeId");
             q.setParameter("projectId",devId);
             return q.list();
}
            catch(Exception e)
          {
           e.printStackTrace();

		}

		return null;

	}

	public boolean setAttendance(DeoAttendance obj) {

		// TODO Auto-generated method stub

		return false;

	}

	public DeoAttendance getBill(Integer id, String month, String year) {

		// TODO Auto-generated method stub

		return null;

	}

	public Employeees getEmployeeById(int employeeId) {

		try {

			Session session=sessionFactory.getCurrentSession();

			Employeees d=session.get(Employeees.class,employeeId);

			 return d;

			 

			

		}

		catch(Exception e)

		{

			e.printStackTrace();

		}

		return null;

	}

	



} */

