package com.example.CourseRegisterationApp.UserModel;

public class JwtResponse
{
	private UserModel userModel;
	private String jwtToken;

	public JwtResponse(UserModel userModel, String jwtToken)
	{
		super();
		this.userModel = userModel;
		this.jwtToken = jwtToken;
	}

	public UserModel getUserModel()
	{
		return userModel;
	}

	public void setUserModel(UserModel userModel)
	{
		this.userModel = userModel;
	}

	public String getJwtToken()
	{
		return jwtToken;
	}

	public void setJwtToken(String jwtToken)
	{
		this.jwtToken = jwtToken;
	}

}
