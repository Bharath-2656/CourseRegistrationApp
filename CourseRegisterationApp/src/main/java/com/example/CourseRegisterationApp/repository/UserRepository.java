package com.example.CourseRegisterationApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.CourseRegisterationApp.UserModel.User;

public interface UserRepository extends JpaRepository<User, Integer>
{
	User findByEmail(String chars);
}