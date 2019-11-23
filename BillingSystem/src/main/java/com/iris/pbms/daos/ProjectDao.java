package com.iris.pbms.daos;

import com.iris.pbms.model.Projects;

import java.util.List;


import com.iris.pbms.model.ProjectEmpAllocation;
import com.iris.pbms.model.RoleConfig;


public interface ProjectDao {
public List<Projects> getAllProjects();

	public Projects getProjectById(int projectId);

	 public List<RoleConfig> getAllRoleConfig();

	/*public boolean setProjectConfig(ProjectConfiguration obj);*/

	public boolean checkRoleconfig(RoleConfig obj);
	/*public boolean setRoleconfig(RoleConfig obj);*/
	public List<RoleConfig> validateProject(int projectId, int roleId, String location);

	public boolean setProjectEmpAllocation(ProjectEmpAllocation ab);

	public List<RoleConfig> getAllProjectConfigNotAllocated();



	

}