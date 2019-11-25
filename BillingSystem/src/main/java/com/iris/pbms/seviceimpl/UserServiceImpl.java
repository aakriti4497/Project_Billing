package com.iris.pbms.seviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iris.pbms.daos.UserDao;
import com.iris.pbms.model.EmpAttendance;
import com.iris.pbms.model.UserTable;
import com.iris.pbms.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {


	@Autowired
    UserDao userDaoObj;
	
	
	public UserTable validateUser(int userid, String password) {

		//some business logic...

		return userDaoObj.validateUser(userid, password);
}
	public UserTable getUserById(int userid) {

		return userDaoObj.getUserById(userid);
   }
	public boolean setAttendance(EmpAttendance peaObj) {
		return setAttendance(peaObj);
	}
}