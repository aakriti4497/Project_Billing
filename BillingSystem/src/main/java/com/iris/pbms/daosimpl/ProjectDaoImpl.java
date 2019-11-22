package com.iris.pbms.daosimpl;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.iris.pbms.daos.ProjectDao;
import com.iris.pbms.model.Projects;
import com.iris.pbms.model.ProjectEmpAllocation;
import com.iris.pbms.model.RoleConfig;



@Repository("projectDao")
public class ProjectDaoImpl implements ProjectDao{

	@Autowired
    SessionFactory sessionFactory;

    public List<Projects> getAllProjects() {
         try {

         Session session=sessionFactory.getCurrentSession();

         Query q=session.createQuery("from com.iris.pbms.model.Projects");

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
   public Projects getProjectById(int projectId)
     {
         try
         {
          Session session=sessionFactory.getCurrentSession();
          Projects c=session.get(Projects.class, projectId);
           return c;

}

        catch(Exception e)

{

         e.printStackTrace();
}
        return null;
}
   public List<RoleConfig> getAllRoleConfig() {
       try {

          Session session=sessionFactory.getCurrentSession();
          Query q=session.createQuery("from com.iris.pbms.model.RoleConfig");
           return q.list();
         }
       catch(Exception e)
	{
        e.printStackTrace();
	}
         return null;
}

/*	public boolean setProjectConfig(ProjectConfiguration obj) {
try {
        Session session=sessionFactory.getCurrentSession();
          session.save(obj);
         return true;
 }
catch(Exception e)
  {
        e.printStackTrace();
}
      return false;
}*/

public boolean checkRoleConfig(RoleConfig obj) {
        try {

           Session session=sessionFactory.getCurrentSession();
           Query q=session.createQuery("from com.iris.pbms.model.RoleConfig where projectId=:projectId and roleId=:roleId and location=:location");

			q.setParameter("projectId",obj.getProObj());
			q.setParameter("roleId",obj.getRoleObj());
            q.setParameter("location",obj.getLocation());

			if(q.list().size()==0) {
                session.save(obj);
                return true;
	}

			}
            catch(Exception e)
               {

                  e.printStackTrace();
                  	}

		return false;

	}



}