package com.iris.pbms.controllers;

import org.springframework.stereotype.Controller;



import java.util.ArrayList;

import java.util.List;



import javax.servlet.http.HttpSession;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.servlet.ModelAndView;



import com.iris.pbms.daos.ProjectDao;

import com.iris.pbms.model.EmpAttendance;

import com.iris.pbms.model.Employeees;

import com.iris.pbms.model.Projects;

import com.iris.pbms.model.ProjectEmpAllocation;

import com.iris.pbms.model.RoleConfig;

import com.iris.pbms.model.EmployeeRole;

import com.iris.pbms.service.EmployeeesService;

import com.iris.pbms.service.ProjectService;

import com.iris.pbms.service.RoleService;

import com.iris.pbms.service.UserService;



import org.springframework.web.bind.annotation.ModelAttribute;





@Controller

public class DEOController {

	

	@Autowired

    HttpSession session;

	

	@Autowired

	UserService userserviceObj;

	

	@Autowired

	ProjectService projectserviceObj;

	

	@Autowired

	EmployeeesService employeeeserviceObj;

	

	

 @RequestMapping(value="/mark",method=RequestMethod.GET)

 public ModelAndView getAttendance() throws Exception{

		

		List<Projects> plist=projectserviceObj.getAllProjects();

		List<Employeees> elist=employeeeserviceObj.getAllEmployeees();

		//Roles roleObj=new Roles();

		EmpAttendance eaObj=new EmpAttendance();

		

		ModelAndView mv=new ModelAndView("DEO");

		mv.addObject("proList",plist);

		mv.addObject("eaObj", eaObj);

		return mv;

	}

 

 @Autowired

 ProjectDao projectDao;

 

 

 @ResponseBody

 @RequestMapping(value="/getEmployeesList",method=RequestMethod.GET)

 public List<Employeees> getAllEmployeees(@RequestParam("projectId")int projectId){

	 System.out.println("Given project Id : "+projectId);

	 

	 List<Employeees> eList=new ArrayList<>();



	 List<RoleConfig> configList=projectDao.getAllRoleConfig();

	 List<ProjectEmpAllocation> allocationList=projectDao.getProjectEmpAllocation();

	 

	 for(RoleConfig config:configList) {

		 for(ProjectEmpAllocation allocation:allocationList) {

			 if(config.getConfigId()==allocation.getPcObj().getConfigurationId()) {

				 Employeees eObj=allocation.geteaObj();

				 eList.add(eObj);

			 }

		 }

	 }

	 

	 System.out.println("eList : "+eList);

	 

	 return eList;

 }



}

