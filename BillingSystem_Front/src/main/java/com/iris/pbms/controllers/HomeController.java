package com.iris.pbms.controllers;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.iris.pbms.daos.UserDao;

import com.iris.pbms.model.UserTable;
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
   UserService userService;
   
   
   
   @RequestMapping(value="signIn",method = RequestMethod.POST)
   public String validateUser(@RequestParam int userId,@RequestParam String password) {
      UserTable userObj=userService.validateUser(userId,password);
      
      if(userObj==null) {
    	  
    	  return "Login";
      }
      else {
    	  String role=userObj.getRole();
    	  session.setAttribute("userObj", userObj);
    	  if(role.equals("admin")) {
    		  return "Admin";
    	  }
    	  else 
    		  return "DataOperatorEntry";
      }
   }
}
   