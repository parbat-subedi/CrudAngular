package com.parbatSubedi.springBoot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.parbatSubedi.springBoot.Dto.UserCreateDto;
import com.parbatSubedi.springBoot.Dto.UserListResponseDto;
import com.parbatSubedi.springBoot.Dto.UserResponseDto;
import com.parbatSubedi.springBoot.entity.Users;
import com.parbatSubedi.springBoot.repository.UserRepository;
import com.parbatSubedi.springBoot.Dto.UserUpdateDto;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public UserResponseDto addUser(UserCreateDto userCreateDto) {
		Users users = new Users();
		
		users.setContact(userCreateDto.getContact());
		users.setEmail(userCreateDto.getEmail());
		users.setName(userCreateDto.getName());
		users.setAddress(userCreateDto.getAddress());
//		users.setId(userCreateDto.getId());
		users.setPassword(userCreateDto.getPassword());
		Users savedUser = userRepository.save(users);
		return getUserResponseDto(savedUser);
	}
	
	public UserResponseDto getUserResponseDto(Users users) {
		UserResponseDto response = new UserResponseDto();
		response.setId(users.getId());
		response.setAddress(users.getAddress());
		response.setContact(users.getContact());
		response.setEmail(users.getEmail());
		response.setName(users.getName());
		response.setId(users.getId());
		response.setPassword(users.getPassword());
		return response;
		
	}
	
	public UserListResponseDto getUsers() {
		List<UserResponseDto> userResponseDto = new ArrayList<>();
		List<Users> users = (List<Users>) userRepository.findAll();
		for (Users user : users) {
			userResponseDto.add(getUserResponseDto(user));
		}

		UserListResponseDto response = new UserListResponseDto();
		response.setUsers(userResponseDto);
		response.setTotal((long) userResponseDto.size());
		return response;
	}
	
	public UserResponseDto updateUsers(long id, UserUpdateDto userUpdateDto) {
		Optional<Users> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			Users users = optionalUser.get();
			users.setContact(userUpdateDto.getContact());
			users.setEmail(userUpdateDto.getEmail());
			users.setPassword(userUpdateDto.getPassword());
			users.setName(userUpdateDto.getName());
			users.setAddress(users.getAddress());
			users.setId(users.getId());

			Users savedUser = userRepository.save(users);
			return getUserResponseDto(savedUser);
		}
		return null;
	}
	
	public UserResponseDto getUserById(long id) {
		Optional<Users> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			return getUserResponseDto(optionalUser.get());
		}
		return null;
	}

	public void deleteByUserId(long id) throws Exception {

		Optional<Users> optionalUser = userRepository.findById(id);

		if (optionalUser.isPresent()) {
//			User user = optionalUser.get();
			userRepository.deleteById(id);
		} else {
			throw new Exception("User having id" + " " + id + " " + "is not available");
		}
	}


}
