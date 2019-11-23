package com.iris.pbms.seviceimpl;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.iris.pbms.daos.EmployeeesDao;
import com.iris.pbms.model.Employeees;
import com.iris.pbms.service.EmployeeesService;

@Service("employeeService")
@Transactional
public class EmployeeesServiceImpl implements EmployeeesService  {
    @Autowired
    EmployeeesDao employeeesDao;

	private SessionFactory sessionFactory;
     public List<Employeees> getAllEmployeees() {

		return employeeesDao.getAllEmployeees();

	}
	public Employeees getEmployeeById(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}
	

}