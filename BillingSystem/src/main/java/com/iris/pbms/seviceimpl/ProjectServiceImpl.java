package com.iris.pbms.seviceimpl;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iris.pbms.daos.ProjectDao;
import com.iris.pbms.model.ProjectEmpAllocation;
import com.iris.pbms.model.Projects;
import com.iris.pbms.model.RoleConfig;
import com.iris.pbms.service.ProjectService;



@Service("projectService")
@Transactional
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	ProjectDao projectdaoObj;
	
	private SessionFactory sessionFactory;
	
	public List<Projects> getAllProjects(){
	return projectdaoObj.getAllProjects();
	
	}
    public List<RoleConfig> getAllRoleConfig(int projectId) {
    	return projectdaoObj.getAllRoleConfig();
    }

	public boolean setRoleConfig(RoleConfig pObj) {
		
		return projectdaoObj.checkRoleconfig(pObj);
	}

	
	public List<RoleConfig> validateProject(int projectId, int roleId, String location) {
		
		return projectdaoObj.validateProject(projectId, roleId, location);
	}
	public boolean setProjectEmpAllocation(ProjectEmpAllocation ab) {
		
		return projectdaoObj.setProjectEmpAllocation(ab);
	}
	public Projects getProjectById(int projectId) {
		
		return projectdaoObj.getProjectById(projectId);
	}
/*	public List<RoleConfig> getAllRoleConfigNotAllocated() {
	
		return projectdaoObj.getAllProjectConfigNotAllocated();	
		}
		*/
	public List<RoleConfig> getAllProjectConfigNotAllocated() {
		return projectdaoObj.getAllProjectConfigNotAllocated();	
	}
	public List<ProjectEmpAllocation> getProjectEmpAllocation() {
		// TODO Auto-generated method stub
		return projectdaoObj.getProjectEmpAllocation();
	}
	
	
	

	}

    