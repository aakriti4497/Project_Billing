
package com.iris.pbms.daos;



import org.springframework.transaction.annotation.Transactional;



import com.iris.pbms.model.UserTable;





public interface UserDao {

	 public UserTable getUserById(int userId);

	 public UserTable validateUser(int userId,String password);

}