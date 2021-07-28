package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRequestDto {
	
	private Long iduser;

	private String fullname;
	
	
	private String email;
	
	private Long idrole;

}
