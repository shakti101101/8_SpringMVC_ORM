package com.springmvc.controller;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.entity.Login;
import com.springmvc.entity.Serversidevalidation;
import com.springmvc.entity.User;
import com.springmvc.service.UserService;

@Controller
public class Homcontroller {

	@Autowired
	private UserService userService;

	@Autowired
	FileUploadController fileUploadController;

	@RequestMapping("/login")
	public String login() {
		System.out.println("login.....................");
		return "login";
	}

	@RequestMapping("/loginUser")
	public String loginUser(HttpServletRequest req, HttpServletResponse res, Login login) {
		System.out.println("loginUser.....................");
		String username1 = req.getParameter("username");
		String password1 = req.getParameter("password");

		System.out.println("username1>>>>" + username1 + "," + password1);
		// session.setAttribute("loginUser", new Login("superadmin"));
		String data = userService.loginUserList(username1, password1);
		System.out.println("loginuser conrtoller>>>>>" + data);
		// String username="",password="";
		String arra[] = data.split("-");
		System.out.println(arra[0] + "-------------------" + arra[1]);
		if (arra[0].equals(username1) && arra[1].equals(password1)) {

			return "redirect:/home";
		} else {
			return "login";
		}
	}

	@RequestMapping("/home")
	public String home() {
		System.out.println("Project Running......................");
		return "home";
	}

	@RequestMapping("/sidebar")
	public String sidebar() {
		System.out.println("sidebar ......................");
		return "sidebar";
	}

	@RequestMapping("/register")
	public String reset() {
		System.out.println("register form ");
		return "register";
	}

	@RequestMapping(path = "/createUser", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute User user, Model m) {
		// user.setImage(img);
		userService.saveUser(user);
		return "redirect:/dispalyUser";
	}

	@RequestMapping(path = "/dispalyUser", method = RequestMethod.GET)
	public String dispalyUser(Model model) {
		// userService.dispalyUser();
		model.addAttribute("user", userService.dispalyUser());
		// System.out.println(userService.toString());
		return "success";
	}

	// ajax call
	@RequestMapping(path = "/dispalyUser2", method = RequestMethod.GET)
	public String dispalyUser(HttpServletRequest request, HttpServletResponse response) {
		// userService.dispalyUser();
		System.out.println("ajax call @@@@@@@@@@@");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			JSONArray result = this.userService.dispalyUser2();
			System.out.println("Result>>>>" + result);
			out.print(result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		// model.addAttribute("user", userService.dispalyUser());
		// System.out.println(userService.toString());
		return "success2";
	}

//edit 
	@RequestMapping(path = "/useredit/{id}", method = RequestMethod.GET)
	public String editUser(@PathVariable("id") String id, Model m) {
		System.out.println("Useredit controller !!!!!!!!!");
		// List<User> user= userService.edituser(id);
		// m.addAttribute("user", userService.edituser(id));
		int n = Integer.parseInt(id);
		List user = (List) userService.edituser(n);
		for (int i = 0; i < user.size(); i++) {
			System.out.println("controller>>" + user.get(i));
		}
		m.addAttribute("usere", user);
		return "user_edit";
	}

	// update
	@RequestMapping(path = "/updateUser", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute User user, Model m, HttpSession session) {

		userService.updateUser(user);
		session.setAttribute("msg", "updateSuccesfully !!!!");
		return "redirect:/dispalyUser";

	}

	// delete user
	@RequestMapping(path = "/userdelete/{id}", method = RequestMethod.GET)
	public String userdelete(@PathVariable("id") String id, HttpSession session) {
		System.out.println("delete controller !!!!!!!!!");
		// List<User> user= userService.edituser(id);
		// m.addAttribute("user", userService.edituser(id));
		int n = Integer.parseInt(id);
		userService.userdelete(n);
		session.setAttribute("msg", "delete succesfully !!!!!");
		return "redirect:/dispalyUser";
	}

	@RequestMapping("/EcxelWrite")
	public String ExcelWrite() {

		userService.ExcelWrite();
		return "excel Generated";

	}


	@RequestMapping("/Report")
	public String signup() {
		return "Fromdate";
	}

		
	@RequestMapping("/reportDate")
	public String reportDate(HttpServletRequest req,HttpServletResponse rep) {
		System.out.println("reportDate !!!!!!!");
		String fromdate =req.getParameter("fromdate");
		String todate =req.getParameter("todate");
		System.out.println("fromdate **"+fromdate);
		System.out.println("todate **"+todate);
		
		this.userService.reportDate(fromdate,todate);
		return "Fromdate";
	}
	
	//serversidevalidation
	
	@RequestMapping("/serversidevalidation")
	public String serversidevalidation(@Valid @ModelAttribute("logindata") Serversidevalidation logindata, BindingResult result) {
		System.out.println("serversidevalidation !!!!!!!!!!!");
		
		if(result.hasErrors())
		{
			System.out.println(result);
		}
		System.out.println(logindata);
		return "valiadationServerside";
	}
	
	
}