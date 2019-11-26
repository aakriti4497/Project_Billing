package com.iris.pbms.controllers;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iris.pbms.model.EmpAttendance;
import com.iris.pbms.model.Employeees;
import com.iris.pbms.model.ProjectEmpAllocation;
import com.iris.pbms.model.Projects;
import com.iris.pbms.model.UserTable;
import com.iris.pbms.service.EmployeeesService;
import com.iris.pbms.service.ProjectService;
import com.iris.pbms.service.RoleService;
import com.iris.pbms.service.UserService;



@Controller

public class HomeController { 

   @RequestMapping(value="/",method = RequestMethod.GET)

   public String printHello(ModelMap model) {

      return "HomePage";

   }

   

   @RequestMapping(value="LoginForm",method = RequestMethod.GET)

   public String openLogin(ModelMap model) {

      return "Login";

   }

   

   

   @Autowired

   HttpSession session;

  

   @Autowired

   UserService userserviceObj;
   
   @Autowired

   EmployeeesService employeeeserviceObj;
   
   @Autowired

	ProjectService projectserviceObj;



	@Autowired

	RoleService roleserviceObj;
	
   

   

   

   @RequestMapping(value="signIn",method = RequestMethod.POST)

   public String validateUser(@RequestParam int userId,@RequestParam String password,ModelMap map) {

      UserTable userObj=userserviceObj.validateUser(userId,password);

      

      if(userObj==null) {

    	  

    	  return "Login";

      }

      else {

    	  String role=userObj.getRole();

    	  session.setAttribute("userObj", userObj);

    	  if(role.equals("admin")) {
    		  map.addAttribute("userObj",userObj);

    		  return "Admin";

    	  }

    	  else {
    		  map.addAttribute("userObj",userObj);


    		  List<Projects> plist=projectserviceObj.getAllProjects();

  		     List<Employeees> elist=employeeeserviceObj.getAllEmployeees();

  		//Roles roleObj=new Roles();

  		EmpAttendance peaObj=new EmpAttendance();

  		

  
  		map.addAttribute("pList",plist);

  		map.addAttribute("peaObj", peaObj);

  		return "DataOperatorEntry";
    		  
    	  }
     

   
          }
   }
   
   @RequestMapping(value="/Logout", method=RequestMethod.GET)



	public String logout() {



		session.removeAttribute("userObj");



		session.invalidate();



		return "HomePage";



	}
 /*  @RequestMapping(value="/HOME", method=RequestMethod.GET)



	public String HOME() {

		return "Admin";

	}

	

	@RequestMapping(value="/HOME", method=RequestMethod.GET)



	public String HOMEe() {

		return "WelcomeDeo";

	}*/





}






   
