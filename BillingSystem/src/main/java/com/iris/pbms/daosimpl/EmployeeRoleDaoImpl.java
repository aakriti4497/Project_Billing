package com.iris.pbms.daosimpl;
import java.util.List;
import com.iris.pbms.daos.EmployeeRoleDao;
import com.iris.pbms.model.EmployeeRole;
import com.iris.pbms.model.RoleConfig;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Component
@Repository(value="roleDao")
@Transactional

public class EmployeeRoleDaoImpl implements EmployeeRoleDao{

    @Autowired

private SessionFactory sessionFactory;//To get session factory from dbconfig.java file

  public List<EmployeeRole> getAllRoles() {
       try {

          Session session=sessionFactory.getCurrentSession();
          Query q=session.createQuery("from com.iris.pbms.model.EmployeeRole");
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