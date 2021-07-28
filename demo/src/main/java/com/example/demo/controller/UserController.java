package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserGetByDateDTO;
import com.example.demo.dto.UserRequestDto;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.exeption.ExceptionMessage;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/create-user")
	public User createuser(@ModelAttribute UserRequestDto request) throws ExceptionMessage{
		return userService.createuser(request);
	}
	
	@PatchMapping("/update-user")
	public User updateuser(@ModelAttribute UserRequestDto request) throws ExceptionMessage {
		return userService.updateuser(request);
	}
	
	@DeleteMapping("/delete-user")
	public String Deletestudent(@ModelAttribute UserRequestDto req) throws ExceptionMessage {
		return userRepository.findById(req.getIduser()).map(student->{
			userRepository.delete(student);
			String status ="sukses menghapus";
			return status;
		}).orElseThrow(()-> new ExceptionMessage("Sorry Student Cannot Find"));
		
	}
	
	@GetMapping("/getusers")
	public List<UserResponseDto> getusers(@ModelAttribute UserGetByDateDTO req) throws ExceptionMessage{
		return userService.getuserss(req);
	}
	
	

}
