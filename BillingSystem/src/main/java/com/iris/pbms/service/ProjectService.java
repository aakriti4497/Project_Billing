package com.iris.pbms.service;

import java.util.List;

import com.iris.pbms.model.ProjectEmpAllocation;
import com.iris.pbms.model.Projects;
import com.iris.pbms.model.RoleConfig;

public interface ProjectService {
	
	public List<Projects> getAllProjects();

	public Projects getProjectById(int projectId);

	public List<RoleConfig> getAllRoleConfig();

	public boolean setRoleConfig(RoleConfig obj);

	public List<RoleConfig> getAllProjectConfigNotAllocated();

    public List<RoleConfig> validateProjects(int projectId, int roleId, String location);

	public boolean setProjectEmpAllocation(ProjectEmpAllocation ab);

	
	
	
}
