package com.example.CourseRegisterationApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CourseRegisterationApp.UserModel.UserModel;
@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer>
{
	UserModel findByEmail(String chars);
}