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

import com.example.demo.dto.RoleDto;
import com.example.demo.exeption.ExceptionMessage;
import com.example.demo.model.Role;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@PostMapping("/create-Role")
	public Role createrole(@ModelAttribute RoleDto request) {
		return roleService.createrole(request);
	}
	
	@GetMapping("/getrole")
	public List<Role> getroles(){
		return roleRepository.findAll();
	}
	
	@PatchMapping("/update-role")
	public Role updaterole(@ModelAttribute RoleDto req) throws ExceptionMessage{
		return roleRepository.findById(req.getIdrole()).map(rol->{
			if(req.getRole_name()!=null) {
				rol.setRole_name(req.getRole_name());
			}
			roleRepository.save(rol);
			return rol;
		}).orElseThrow(()->new ExceptionMessage("maaf tidak ditemukan"));
	}
	
	@DeleteMapping("/delete-role")
	public String deleterole(@ModelAttribute RoleDto req) throws ExceptionMessage{
		return roleRepository.findById(req.getIdrole()).map(rol->{
			roleRepository.delete(rol);
			String status =" sukses menghapus role";
			return status;
		}).orElseThrow(()->new ExceptionMessage("maaf role tidak ditemukan"));
	}
}
