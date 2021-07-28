package com.example.demo.dto;

import java.time.ZonedDateTime;
import java.util.List;

import com.example.demo.model.Role;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class UserResponseDto {

	private Long iduser;
	
	private String fullname;
	
	private String email;
	
	private ZonedDateTime CreatedAt;
	
	private List<Role> role;
}
