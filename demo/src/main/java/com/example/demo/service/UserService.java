package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UserGetByDateDTO;
import com.example.demo.dto.UserRequestDto;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.exeption.ExceptionMessage;
import com.example.demo.model.User;

public interface UserService {

	
	
	User updateuser(UserRequestDto request)throws ExceptionMessage;

	User createuser(UserRequestDto request) throws ExceptionMessage;

	List<UserResponseDto> getuserss(UserGetByDateDTO req) throws ExceptionMessage;

}
