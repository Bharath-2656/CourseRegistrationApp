package com.example.CourseRegisterationApp.controller;

import java.awt.desktop.UserSessionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.CourseRegisterationApp.repository.UserRepository;
import com.example.CourseRegisterationApp.UserModel.User;

@Controller
public class Controllerclass
{
	@Autowired
	UserRepository userRepository;

	@RequestMapping("/home")
	public String Homepage()
	{
		return "homepage.jsp";
	}

	@GetMapping("/login")
	public String loginMethod(Model model)
	{
		User user = new User();
		model.addAttribute("user", user);
		return "login.jsp";
	}

	@PostMapping("/login")
	public String loginComplete(@RequestParam String email, @RequestParam String password)
	{
		User user = userRepository.findByEmail(email);
		if (user != null && user.getPassword().equals(password))
		{
			return "login_success.jsp";
		}
		else
		{
			return "login_fail.jsp";
		}
	}

	@GetMapping("/register")
	public String register(Model model)
	{
		User user = new User();
		model.addAttribute("user", user);
		return "register.jsp";
	}

	@PostMapping("/register")
	public String registeration_completed(User user)
	{
		if (!user.getEmail().matches("[a-zA-Z0-9]+[@]{1}[a-zA-Z]+[.][a-zA-Z]{2,3}"))
		{
			return "registeration_failure.jsp";
		}
		if (!user.getPassword()
				.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$"))
		{	
			
			return "registeration_failure.jsp";
		}
		if(user.getPassword()!=user.getConfirm_password())
		{
			return "registeration_failure.jsp";
		}
		else
		{
			System.out.println(user);
			userRepository.save(user);
			return "registration_success.jsp";
		}
	}

	@PostMapping("/login_fail")
	public String loginFailed()
	{
		return "login_fail.jsp";
	}
}
