package com.iris.pbms.test;



import static java.lang.System.out;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;  //Static import

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;


import com.iris.pbms.config.DBConfig;
import com.iris.pbms.daos.UserDao;

import com.iris.pbms.model.UserTable;

public class UserTest {

	private static UserDao userDaoObj;
	
	@BeforeClass
	public static void init(){
		out.println("I m in init - start");
		//Created the object of Spring container
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
		
		//Passing the object of Configuration to the Spring container and refershing it
   	 	//context.register(DBConfig.class);
   	 	//context.refresh();
   	 	
   	 	//Asking the object of PRoductDao from the spring container so that we can 
   	 	//test its methods.
   	 	userDaoObj=context.getBean(UserDao.class,"userDao");
   	 	out.println("I m in init - end");
	}
	
	
	@Test
	@Ignore
	public void getUserByIdTest(){
		UserTable userObj=userDaoObj.getUserById(3376);
		assertNotNull("user with given id doesnt exist", userObj);
	}
	
    @Test
    public void showUserTest() {
    	UserTable userObj1=new UserTable();
    	UserTable userObj2=userDaoObj.validateUser(3376,"aak4");
    	assertNotNull("user doesnt exist");
    	
    	
    	
	}
	
}




