package com.iris.pbms.service;

import java.util.List;

import com.iris.pbms.model.Projects;
import com.iris.pbms.model.RoleConfig;

public interface ProjectService {
	
	public List<Projects> getAllProjects();
	public List<RoleConfig> getAllRoleConfig();

}
