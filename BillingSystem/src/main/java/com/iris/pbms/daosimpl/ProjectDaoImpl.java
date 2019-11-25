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

public boolean checkRoleconfig(RoleConfig obj) {
        try {

           Session session=sessionFactory.getCurrentSession();
           Query q=session.createQuery("from com.iris.pbms.model.RoleConfig"
           		+ " where projectid=:projectId and roleid=:roleId and location=:location");

			q.setParameter("projectId",obj.getProjectId());
			q.setParameter("roleId",obj.getRoleId());
            q.setParameter("location",obj.getLocation());

            List list=q.list();
            
            System.out.println("List of Role Config : "+list);
            
			if(list.size()==0) {
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
/*
public boolean setRoleconfig(RoleConfig obj) {
	try {

		   Session session=sessionFactory.getCurrentSession();

		   Query q=session.createQuery("from com.iris.pbms.RoleConfig where projectid=:projectId and roleid=:roleId and location=:location");

		   q.setParameter("projectId",obj.getProjectId());

		   q.setParameter("roleId",obj.getRoleId());

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

		  
}*/

    public boolean setProjectEmpAllocation(ProjectEmpAllocation obj1) {
    	System.out.println("ProjectEmpAllocation "+obj1);
    	try {



    		Session session=sessionFactory.getCurrentSession();

    		Query q=session.createQuery("from com.iris.pbms.model.ProjectEmpAllocation where employeeId=:employeeId and configId=:configId");

    		q.setParameter("employeeId",obj1.empObj().getEmployeeId());

    		q.setParameter("configId",obj1.getRoleConfig().getConfigId());

    		if(q.list().size()==0) {

    			session.save(obj1);

    			return true;

    		}

    		}
		
        catch(Exception e)
           {

              e.printStackTrace();
              	}
    	
    	return false;



	}


    public List<ProjectEmpAllocation> getProjectEmpAllocation() {

    	try {
            Session session=sessionFactory.getCurrentSession();

			Query q=session.createQuery("from com.iris.pbms.model.ProjectEmpAllocation");

			

			List list=q.list();

			return list;
}


	catch(Exception e)

{

        e.printStackTrace();
		}
    	return null;


    }


public List<RoleConfig> validateProject(int projectId, int roleId, String location) {

	try {

      Session session=sessionFactory.getCurrentSession();
      System.out.println("Invalid");
       Query q=session.createQuery("from com.iris.pbms.model.RoleConfig where proObj.projectId=:projectId and roleObj.roleId=:roleId and location=:location");
          q.setParameter("projectId",projectId);
          q.setParameter("roleId",roleId);
          q.setParameter("location",location);
          System.out.println("Invalid2");
          System.out.println(q.list());
         return q.list();
         
         

}

      catch(Exception e)
{

    e.printStackTrace();

}
return null;
}


           public List<RoleConfig> getAllRoleConfig(int projectId) {
          try {
            Session session=sessionFactory.getCurrentSession();
           Query q=session.createQuery("from com.iris.pbms.model.RoleConfig where proObj.projectId=:projectId");
            q.setParameter("projectId",projectId);
           return q.list();
          }
            catch(Exception e)
{

            e.printStackTrace();
	}

         return null;
}
           public List<RoleConfig> getAllProjectConfigNotAllocated() {
          try {

                 Session session=sessionFactory.getCurrentSession(); 
               	Query q=session.createQuery("from RoleConfig where configId not in(select pcObj.configId from ProjectEmpAllocation)");
                     return q.list();
                     }
                catch(Exception e)
	{
               	e.printStackTrace();
}
              return null;
  	}
		
		
	
		}	
	
		
           
