package com.bikkadIT.service;

import java.util.List;

import com.bikkadIT.Dtos.PageableResponse;
import com.bikkadIT.Dtos.UserDto;

public interface UserServiceI {

	// Create
	UserDto createUser(UserDto userDto);

	// Update
	UserDto updateUser(UserDto userDto, Long userId);

	// delete
	Void deleteUser(Long userId);

	// get all user
	PageableResponse<UserDto> getAllUser(int pageNumber,int pageSize, String sortBy,String sortDire);

	// get Single by User
	UserDto getuserById(Long UserId);

	// get Single by email
	UserDto getUserByEmail(String email);

	// Serach User

	List<UserDto> searchUser(String keywords);

	// other user Specific feature

}
