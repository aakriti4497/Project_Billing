package com.iris.pbms.test;
import static java.lang.System.out;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.iris.pbms.config.DBConfig;
import com.iris.pbms.daos.EmployeeRoleDao;
import com.iris.pbms.model.EmployeeRole;
import com.iris.pbms.model.RoleConfig;

public class RoleTest {

	private static EmployeeRoleDao userdaoobj;

	@BeforeClass
    public static void init(){

		out.println("I m in init - start");

		//Created the object of Spring container

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);

		

		userdaoobj=context.getBean(EmployeeRoleDao.class,"roleDao");

   	 	out.println("I m in init - end");

	}

	

	@Test

	@Ignore

	public void getAllProductsTest(){

		List<EmployeeRole> pList=userdaoobj.getAllRoles();

		out.println(pList);

		Assert.assertNotEquals("Not Products Found...", pList.size(), 0);

	}

	

}