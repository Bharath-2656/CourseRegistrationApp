package com.example.CourseRegisterationApp.UserModel;

public class JwtClass
{
	private final String jwt;

	public JwtClass(String jwt)
	{
		this.jwt = jwt;
	}

	public String getJwt()
	{
		return jwt;
	}
}
