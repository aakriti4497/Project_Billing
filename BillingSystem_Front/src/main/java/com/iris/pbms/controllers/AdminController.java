 package com.iris.pbms.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iris.pbms.model.EmployeeRole;
import com.iris.pbms.model.Employeees;
import com.iris.pbms.model.ProjectEmpAllocation;
import com.iris.pbms.model.Projects;
import com.iris.pbms.model.RoleConfig;
import com.iris.pbms.service.EmployeeesService;
import com.iris.pbms.service.ProjectService;
import com.iris.pbms.service.RoleService;
import com.iris.pbms.service.UserService;

@Controller
public class AdminController {
	
	@Autowired
	ProjectService projectserviceObj;

	@Autowired
	RoleService roleserviceObj;
	
	@Autowired
	EmployeeesService employeeeserviceObj;

	 @RequestMapping(value="/configure",method=RequestMethod.GET)
	 public ModelAndView getAllconfig() throws Exception{
 
		 
		 List<Projects>plist=projectserviceObj.getAllProjects();
		 List<EmployeeRole> rolelist=roleserviceObj.getAllRoles();
		 
		  
		  ModelAndView mv=new ModelAndView("Configure");
		  mv.addObject("configObj", new RoleConfig());
		  mv.addObject("plist",plist);
		  System.out.println(plist);
		  mv.addObject("roleList",rolelist);
		  //mv.addObject("roleob",roleObj);
		  return mv;
		 }
		 
		 @RequestMapping(value="/submitConfig",method=RequestMethod.GET)
		 public ModelAndView submitConfig(@ModelAttribute(name="pObj") @Valid RoleConfig pObj,BindingResult result,ModelMap map) {

				try {
					System.out.println(pObj);

					boolean saved = projectserviceObj.setRoleConfig(pObj);

					map.addAttribute("msg","Project Configuration Successful");

					System.out.println("done in project config");

				

					if(saved) {

						ModelAndView mv=new ModelAndView("redirect:http://localhost:1234/ProjectBilling/Config");

						mv.addObject("msg","Configuration Added Succesfully..");

						System.out.println("return to page and added successfully");

						return mv;

					} else {

						ModelAndView mv=new ModelAndView("redirect:http://localhost:1234/ProjectBilling/Config");

						mv.addObject("errorMsg","noooo");

						System.out.println("return to page and not added added successfully");

						return mv;

					}

				}

				catch(Exception e)

				{

					System.out.println("I m catch");

					//e.printStackTrace();

					ModelAndView mv=new ModelAndView("redirect:http://localhost:1234/ProjectBilling/Config");

					mv.addObject("errorMsg","Project already configured..");

					return mv;

				}

				

			}
		/* public ModelAndView setConfig(@ModelAttribute(name="pObj") RoleConfig pObj) throws Exception{
		  
		  System.out.println(pObj);
		  boolean saved=projectserviceObj.setRoleConfig(pObj);
		  System.out.println("saved : "+saved);
		  map.addAttribute("msg","Project Configuration Successful");

			System.out.println("done in project config");
		  
		  List<RoleConfig> rconfig=projectserviceObj.getAllRoleConfig();
		  List<Projects> plist=projectserviceObj.getAllProjects();
		  List<EmployeeRole> rlist=roleserviceObj.getAllRoles();
		  //Roles roleObj=new Roles();
		  RoleConfig rObj=new RoleConfig();
		  

		  
		  ModelAndView mv=new ModelAndView("configure");
		  mv.addObject("configList", rconfig);
		  mv.addObject("plist",plist);
		  System.out.println(plist);
		  mv.addObject("roleList",rlist);
		  //mv.addObject("roleob",roleObj);
		  mv.addObject("pObj", pObj);
		  
		  if(saved) {
		   mv.addObject("msg", "Configuration done!");
		   return mv;
		   
		  }
		  else {
		  mv.addObject("msg", "Configuration error!");
		  return mv;
		  }
		 } */
		 

		 @RequestMapping(value="/allocate",method=RequestMethod.GET)
              public ModelAndView getAllocated() throws Exception{

				List<Projects> plist=projectserviceObj.getAllProjects();

				List<EmployeeRole> rlist=roleserviceObj.getAllRoles();

				List<Employeees> elist=employeeeserviceObj.getAllEmployeees();

				ModelAndView mv=new ModelAndView("Allocate");

				mv.addObject("plist",plist);

				mv.addObject("roleList",rlist);

				mv.addObject("elist",elist);

				return mv;



		}
		 
		 @RequestMapping(value="/submitallocate",method=RequestMethod.GET)

         public String validateConfigure(@RequestParam int projectId,@RequestParam int roleId,@RequestParam String location,@RequestParam int employeeId,ModelMap map){
         System.out.println(projectId+""+roleId+""+location+""+employeeId);

				

				List<Projects> plist=projectserviceObj.getAllProjects();

				List<EmployeeRole> rlist=roleserviceObj.getAllRoles();

				List<Employeees> elist=employeeeserviceObj.getAllEmployeees();

				map.addAttribute("pList",plist);

				map.addAttribute("roleList",rlist);

				map.addAttribute("empList",elist);



	       List<RoleConfig> Obj=projectserviceObj.validateProjects(projectId,roleId,location);
	       System.out.println("OBJ = "+Obj);
	       
           RoleConfig configObj=Obj.get(0);

           Employeees empObj=employeeeserviceObj.getEmployeeById(employeeId);

           ProjectEmpAllocation ab=new ProjectEmpAllocation();


            ab.setempObj(empObj);

            ab.setRoleConfig(configObj);



			boolean saved=projectserviceObj.setProjectEmpAllocation(ab);

			if(saved) {

				map.addAttribute("msg","Allocation done");

				return "allocate";

				

			}

			else {

				map.addAttribute("msg","Allocation error");

			return "allocate";

			}

	}

		}

