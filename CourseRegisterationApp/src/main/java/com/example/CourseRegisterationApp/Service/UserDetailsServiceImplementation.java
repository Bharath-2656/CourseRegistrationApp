package com.example.CourseRegisterationApp.Service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.CourseRegisterationApp.UserModel.UserModel;
import com.example.CourseRegisterationApp.repository.UserRepository;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService
{
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		UserModel userModel = userRepository.findByEmail(username);
		if (userModel != null)
		{
			return new User(userModel.getEmail(), userModel.getPassword(), new ArrayList<>());
		}
		else
		{
			throw new UsernameNotFoundException(username + " not found");

		}
	}

}
