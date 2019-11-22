package com.iris.pbms.seviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iris.pbms.daos.ProjectDao;
import com.iris.pbms.model.Projects;
import com.iris.pbms.model.RoleConfig;
import com.iris.pbms.service.ProjectService;



@Service("projectService")
@Transactional
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	ProjectDao projectdaoObj;
	
	public List<Projects> getAllProjects(){
	return projectdaoObj.getAllProjects();
	
	
	
}
    public List<RoleConfig> getRoleConfig() {
    	return projectdaoObj.getAllRoleConfig();
    }
	public List<RoleConfig> getAllRoleConfig() {
		// TODO Auto-generated method stub
		return projectdaoObj.getAllRoleConfig();
	}
    }