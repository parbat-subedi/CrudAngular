package com.parbatSubedi.springBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.parbatSubedi.springBoot.Dto.UserCreateDto;
import com.parbatSubedi.springBoot.Dto.UserListResponseDto;
import com.parbatSubedi.springBoot.Dto.UserResponseDto;
import com.parbatSubedi.springBoot.service.UserService;
import com.parbatSubedi.springBoot.Dto.UserUpdateDto;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService userService;
	@PostMapping
	@ResponseStatus(code = HttpStatus.OK)
	
	public UserResponseDto addUser(@RequestBody UserCreateDto userCreateDto) {
		return userService.addUser(userCreateDto);
	}
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public UserListResponseDto getUsers() {
		return userService.getUsers();
	}

	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public UserResponseDto getUserById(@PathVariable("id") long id) {
		return userService.getUserById(id);
	}

	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public UserResponseDto updateUsers(@PathVariable("id") long id, @RequestBody UserUpdateDto userUpdateDto) {
		return userService.updateUsers(id, userUpdateDto);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteByUserId(@PathVariable long id) throws Exception {
		userService.deleteByUserId(id);
	}


}
