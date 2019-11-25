package com.iris.pbms.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iris.pbms.model.EmpAttendance;
import com.iris.pbms.model.Employeees;
import com.iris.pbms.model.ProjectEmpAllocation;
import com.iris.pbms.model.Projects;
import com.iris.pbms.model.RoleConfig;
import com.iris.pbms.service.EmployeeesService;
import com.iris.pbms.service.ProjectService;
import com.iris.pbms.service.UserService;


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
	
	public boolean checkSession(ModelMap map) {

		if(session.getAttribute("uObj")==null) {
           map.addAttribute("msg","Session does not exist");
              return true;

		}

		return false;
	
	}
	@RequestMapping(value="/mark",method=RequestMethod.GET)
	public ModelAndView getAttendance(ModelMap map) throws Exception{
		
		 

		 if(checkSession(map)) {
               ModelAndView mv=new ModelAndView("Login");
               return mv;

			}

			
	
		List<Projects> plist=projectserviceObj.getAllProjects();
        List<Employeees> elist=employeeeserviceObj.getAllEmployeees();
        ProjectEmpAllocation peaObj=new ProjectEmpAllocation();
        
        ModelAndView mv=new ModelAndView("DEO");
        mv.addObject("plist",plist);
        mv.addObject("peaObj", peaObj);
        return mv;
	}
        
        @ResponseBody
        @RequestMapping(value="/getEmployeeesList",method=RequestMethod.GET)
        public List<Employeees> getAllEmployees(@RequestParam("projectId") int projectId){
        System.out.println("Given project Id : "+projectId);
        List<Employeees> eList=new ArrayList();
        List<RoleConfig> configList=projectserviceObj.getAllRoleConfig(projectId);
        List<ProjectEmpAllocation> allocationList=projectserviceObj.getProjectEmpAllocation();
        
        for(RoleConfig config: configList) {
        	for(ProjectEmpAllocation allocation:allocationList) {
        		if(config.getConfigId()==allocation.getRoleConfig().getConfigId()) {
        			Employeees eObj=allocation.empObj();
        		eList.add(eObj);
        	}
        }
		
	}
        System.out.println("elist : "+eList);
         return eList;

	}
        @RequestMapping(value="/submitData",method=RequestMethod.GET)
        public ModelAndView submitAttendance(@ModelAttribute(name="peaObj") EmpAttendance peaObj,@RequestParam int employeeId,@RequestParam int projectId,ModelMap map) throws Exception{ 
        
        	System.out.println(peaObj);
        	Employeees eObj=employeeeserviceObj.getEmployeeById(employeeId);
        	Projects proObj=projectserviceObj.getProjectById(projectId);
        	
        	peaObj.setEmpObj(eObj);
            peaObj.setProObj(proObj);
            
             boolean saved=userserviceObj.setAttendance(peaObj);
             ModelAndView mv= new ModelAndView("DEO");

       	 if(saved) {
       		 mv.addObject("msg", "Attendance Marked!");
       		 return mv;
       		 }
                   else {
           mv.addObject("msg", "Attendance cannot be marked!");

       		return mv;

       		

        }

     }



       }



