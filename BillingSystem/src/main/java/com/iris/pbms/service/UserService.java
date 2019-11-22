package com.iris.pbms.service;

import com.iris.pbms.model.UserTable;

public interface UserService {
	
	 public UserTable getUserById(int userid);

	 public UserTable validateUser(int userid,String password);
      
	 
}
