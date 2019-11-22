package com.iris.pbms.seviceimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iris.pbms.daos.EmployeeRoleDao;
import com.iris.pbms.daos.ProjectDao;
import com.iris.pbms.model.EmployeeRole;
import com.iris.pbms.service.RoleService;



@Service("roleService")
@Transactional
public class RoleSeviceImpl implements RoleService {
	
	@Autowired
	EmployeeRoleDao employeeroledaoObj;
	
	public List<EmployeeRole> getAllRoles() {
		return employeeroledaoObj.getAllRoles();
		
	}
}
