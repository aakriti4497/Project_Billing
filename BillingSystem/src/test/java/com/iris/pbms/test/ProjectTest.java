package com.iris.pbms.test;
import static java.lang.System.out;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.iris.pbms.config.DBConfig;
import com.iris.pbms.daos.ProjectDao;
import com.iris.pbms.model.Projects;

public class ProjectTest {
private static ProjectDao projectdaoobj;

      @BeforeClass

	public static void init(){

		out.println("I m in init - start");

		//Created the object of Spring container

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);

		

		projectdaoobj=context.getBean(ProjectDao.class,"projectDao");

   	 	out.println("I m in init - end");

	}

	

	@Test

	@Ignore

	public void getAllProductsTest(){

		List<Projects> pList=projectdaoobj.getAllProjects();

		out.println(pList);

		Assert.assertNotEquals("Not Products Found...", pList.size(), 0);

	}

}