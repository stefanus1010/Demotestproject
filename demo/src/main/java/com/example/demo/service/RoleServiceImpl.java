package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RoleDto;
import com.example.demo.model.Role;
import com.example.demo.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{

	
	@Autowired
	private RoleRepository roleRepository;
	@Override
	public Role createrole(RoleDto request) {
		
		Role role = new Role();
		role.setRole_name(request.getRole_name());
		roleRepository.save(role);
		// TODO Auto-generated method stub
		return role;
	}

}
