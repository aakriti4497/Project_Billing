 package com.iris.pbms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iris.pbms.model.EmployeeRole;
import com.iris.pbms.model.Projects;
import com.iris.pbms.model.RoleConfig;
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
	UserService userserviceObj;

	 @RequestMapping(value="/configure",method=RequestMethod.GET)
	 public ModelAndView getAllconfig() throws Exception{
 List<RoleConfig> rconfig=projectserviceObj.getAllRoleConfig();
		 List<Projects>plist=projectserviceObj.getAllProjects();
		 List<EmployeeRole> rolelist=roleserviceObj.getAllRoles();
		  RoleConfig config=new RoleConfig();
		  
		  ModelAndView mv=new ModelAndView("configure");
		  mv.addObject("configList", rconfig);
		  mv.addObject("plist",plist);
		  System.out.println(plist);
		  mv.addObject("roleList",rolelist);
		  //mv.addObject("roleob",roleObj);
		  return mv;
		 }
		 
		 @RequestMapping(value="/submitConfig",method=RequestMethod.GET)
		 public ModelAndView setConfig(@ModelAttribute(name="pObj") RoleConfig pObj) throws Exception{
		  
		  System.out.println(pObj);
		  boolean saved=projectserviceObj.setRoleConfig(pObj);
		  System.out.println("saved : "+saved);
		  
		  
		  List<RoleConfig> rconfig=projectserviceObj.getAllRoleConfig();
		  List<Projects> plist=projectserviceObj.getAllProjects();
		  List<EmployeeRole> rlist=roleserviceObj.getAllRoles();
		  //Roles roleObj=new Roles();
		  RoleConfig rObj=new RoleConfig();
		  

		  
		  ModelAndView mv=new ModelAndView("configure");
		  mv.addObject("configList", rconfig);
		  mv.addObject("projList",plist);
		  System.out.println(plist);
		  mv.addObject("roleList",rlist);
		  //mv.addObject("roleob",roleObj);
		  mv.addObject("pObj", projObj);
		  
		  if(saved) {
		   mv.addObject("msg", "Configuration done!");
		   return mv;
		   
		  }
		  else {
		  mv.addObject("msg", "Configuration error!");
		  return mv;
		  }
		 } 



