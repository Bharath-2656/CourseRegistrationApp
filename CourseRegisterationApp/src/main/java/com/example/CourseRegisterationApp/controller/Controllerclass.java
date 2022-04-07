package com.example.CourseRegisterationApp.controller;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.CourseRegisterationApp.Service.UserDetailsServiceImplementation;
import com.example.CourseRegisterationApp.UserModel.AuthenticationRequest;
import com.example.CourseRegisterationApp.UserModel.JwtClass;
import com.example.CourseRegisterationApp.UserModel.UserModel;
import com.example.CourseRegisterationApp.Util.JwtUtil;
import com.example.CourseRegisterationApp.repository.UserRepository;

@Controller
public class Controllerclass
{
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private UserDetailsServiceImplementation userDetailsService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@RequestMapping("/home")
	public String Homepage()
	{
		return "homepage.jsp";
	}

	@GetMapping("/register")
	public String register(Model model)
	{
		UserModel userModel = new UserModel();
		model.addAttribute("user", userModel);
		return "register.jsp";
	}

	@PostMapping("/register")
	public String registeration_completed(UserModel userModel)
	{
		if (!userModel.getEmail().matches("[a-zA-Z0-9]+[@]{1}[a-zA-Z]+[.][a-zA-Z]{2,3}"))
		{
			return "registeration_failure.jsp";
		}
		if (!userModel.getPassword()
				.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$"))
		{
			return "registeration_failure.jsp";
		}

		if (userModel.getPassword() != userModel.getConfirm_password())
		{
			return "registeration_failure.jsp";
		}
		else
		{
			System.out.println(userModel);
			userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
			userRepository.save(userModel);
			return "registration_success.jsp";
		}
	}

//	 @GetMapping("/login")
//	 public String loginMethod(Model model)
//	 {
//	 UserModel userModel = new UserModel();
//	 model.addAttribute("user", userModel);
//	 return "login.jsp";
//	 }
	@PostMapping("/login")
	public String loginComplete(@RequestParam String email, @RequestParam String password)
	{
		UserModel userModel = userRepository.findByEmail(email);
		if (userModel != null && userModel.getPassword().equals(password))
		{
			return "login_success.jsp";
		}
		else
		{
			return "login_fail.jsp";
		}
	}

	@PostMapping("/login_fail")
	public String loginFailed()
	{
		return "login_fail.jsp";
	}

	@GetMapping("/authenticate")
	public String loginMethod(Model model)
	{
		UserModel userModel = new UserModel();
		model.addAttribute("user", userModel);
		return "login.jsp";
	}

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception
	{
		try
		{
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		}
		catch (BadCredentialsException error)
		{
			throw new Exception("Incorrect username or password", error);
			
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtClass(jwt));
	}

//	@GetMapping("/logout")
//	public String getLogout()
//	{
//		return "logout.jsp";
//	}

	@GetMapping("/logout_success")
	public String logout()
	{

		return "logout_success.jsp";
	}

	@GetMapping("/area_of_intrest")
	public String areaofintrest()
	{
		return "area_of_intrest.jsp";
	}

//	public void storeTokenInCookie(UserDetails userDetails, HttpServletResponse response)
//	{
//		String jwt = jwtTokenUtil.generateToken(userDetails);
//		response.addCookie(cookieService.getJwtCookie(jwt));
//	}
}
