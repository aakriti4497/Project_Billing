package com.iris.pbms.service;
import com.iris.pbms.model.UserTable;
import org.springframework.transaction.annotation.Transactional;

public class UserService {

	 public UserTable getUserById(int userId);

	 public UserTable validateUser(int userId,String password) {
		
	}
}
