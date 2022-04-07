package com.example.CourseRegisterationApp.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.example.CourseRegisterationApp.UserModel.UserModel;

public class UserDetailsImplementation implements UserDetails
{
	private String username;
	private String password;
	List<GrantedAuthority> authorities;

	public UserDetailsImplementation()
	{
	}

	public UserDetailsImplementation(UserModel userModel)
	{
		this.username = userModel.getEmail();
		this.password = userModel.getPassword();
		this.authorities = Arrays.stream(userModel.getRole().split(",")).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}

	public String getPassword()
	{
		return password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		return authorities;
	}
	
//	@Override
//	private Set getAuthority(UserModel userModel)
//	{
//		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
//		userModel.getRole().forEach(role -> { authorities.add(new SimpleGrantedAuthority("ROLE_"+ role.getRolename()));
//		
//		});
//		return authorities;
//	}
	
	@Override
	public String getUsername()
	{

		return username;
	}

	@Override
	public boolean isAccountNonExpired()
	{
		return true;
	}

	@Override
	public boolean isAccountNonLocked()
	{
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired()
	{
		return true;
	}

	@Override
	public boolean isEnabled()
	{
		return true;
	}

}
