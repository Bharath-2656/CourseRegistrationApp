package com.example.CourseRegisterationApp.UserModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class User
{

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "id", nullable = false)
	private Integer id;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "age", nullable = false)
	private Integer age;
	@Column(unique = true, name = "email", nullable = false)
	private String email;
	@Column(name = "password", nullable = false)
	private String password;
	@Column(name = "confirm_password", nullable = false)
	private String confirm_password;

	public String getConfirm_password()
	{
		return confirm_password;
	}

	public void setConfirm_password(String confirm_password)
	{
		this.confirm_password = confirm_password;
	}

	public User()
	{

	}

	public User(Integer id, String name, Integer age, String email, String password, String confirm_password)
	{
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.password = password;
		this.confirm_password = confirm_password;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Integer getAge()
	{
		return age;
	}

	public void setAge(Integer age)
	{
		this.age = age;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Override
	public String toString()
	{
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + ", password=" + password
				+ ", confirm_password=" + confirm_password + "]";
	}

}