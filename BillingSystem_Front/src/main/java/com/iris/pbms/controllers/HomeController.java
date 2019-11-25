package com.iris.pbms.controllers;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
      /*
      @WebServlet("/logout")
      public class LogoutServlet extends HttpServlet {

          protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              request.getSession().invalidate();
              response.sendRedirect(request.getContextPath() + "/LoginPage.html"); */
          }

}

   