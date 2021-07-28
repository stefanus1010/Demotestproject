package com.example.demo.service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.time.*;

import org.hibernate.internal.ExceptionMapperStandardImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.dto.UserGetByDateDTO;
import com.example.demo.dto.UserRequestDto;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.exeption.ExceptionMessage;
import com.example.demo.model.PivotRoleandUser;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.PivotRoleUserRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.utils.DateTimeUtils;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PivotRoleUserRepository pivotRoleUserRepository;
	

	@Override
	public User updateuser(UserRequestDto request) throws ExceptionMessage {
		if( request.getIduser() !=null) {
			User user = userRepository.findById(request.getIduser()).orElseThrow(()->new ExceptionMessage("maaf user tidak ditemukan"));
			if(request.getIdrole() !=null) {
			PivotRoleandUser pivotRoleandUser= new PivotRoleandUser();
			Role role = roleRepository.findById(request.getIdrole()).orElseThrow(()->new ExceptionMessage("maaf role tidak ditemukan"));
			
			pivotRoleandUser.setRole(role);
			pivotRoleandUser.setUser(user);
			pivotRoleUserRepository.save(pivotRoleandUser);
		
		
			}

			if(request.getEmail()!= null) {
				user.setEmail(request.getEmail());
			}
			if(request.getFullname()!=null) {
				user.setFullname(request.getFullname());
				}
			userRepository.save(user);
			return user;
	}else {
		throw new ExceptionMessage("maaf iduser tidak boleh kosong ");
	}
		
	}



	@Override
	public User createuser(UserRequestDto request) throws ExceptionMessage {
		if(request.getEmail()== null) {
			throw new ExceptionMessage("maaf email tidak boleh kosong");
		}
		if(request.getFullname()==null) {
			throw new ExceptionMessage("maaf fullname tidak boleh kosong");
		}
		User user = modelMapper.map(request, User.class);
		
		userRepository.save(user);

		return user;
		// TODO Auto-generated method stub
		
	}



	@Override
	public List<UserResponseDto> getuserss(UserGetByDateDTO req) throws ExceptionMessage {
		 ZonedDateTime dateStart = ZonedDateTime.of(req.getDatestart(), LocalTime.MIN, ZoneId.of("Asia/Jakarta"));

	        ZonedDateTime dateEnd = ZonedDateTime.of(req.getDateend(), LocalTime.MAX, ZoneId.of("Asia/Jakarta"));

		
		List<User> user =userRepository.findByCreatedAtBetween(dateStart, dateEnd);
//		List<PivotRoleandUser> pivotRoleandUsers = pivotRoleUserRepository.findByUserIn(user);
		// TODO Auto-generated method stub
		List<UserResponseDto> respons = user.stream().map(us->{
			UserResponseDto usere = modelMapper.map(us, UserResponseDto.class);
			List<PivotRoleandUser> roles= pivotRoleUserRepository.findByUser(us);
			List<Role> rol = roles.stream().map(role->modelMapper.map(role.getRole(), Role.class)).collect(Collectors.toList());
			usere.setRole(rol);
//			List<Role> roles = (List<Role>) pivotRoleandUsers.stream().filter(z->z.getUser().equals(us));
//			usere.setRole(roles);
			return usere;
		}).collect(Collectors.toList());
		
		return respons;
	}



	

}
