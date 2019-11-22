package com.iris.pbms.daos;
import java.util.List;
import com.iris.pbms.model.Projects;
import com.iris.pbms.model.ProjectEmpAllocation;
import com.iris.pbms.model.RoleConfig;


public interface ProjectDao {
public List<Projects> getAllProjects();

	public Projects getProjectById(int projectId);

	 public List<RoleConfig> getAllRoleConfig();

	/*public boolean setProjectConfig(ProjectConfiguration obj);*/

	public boolean checkRoleconfig(RoleConfig obj);



	

}