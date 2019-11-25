package com.iris.pbms.service;

import com.iris.pbms.model.EmpAttendance;
import com.iris.pbms.model.UserTable;

public interface UserService {
	
	 public UserTable getUserById(int userid);

	 public UserTable validateUser(int userid,String password);

	public boolean setAttendance(EmpAttendance peaObj);
      
	 
}
