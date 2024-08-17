package com.bikkadIT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bikkadIT.Dtos.PageableResponse;
import com.bikkadIT.Dtos.UserDto;
import com.bikkadIT.payload.ApiResponse;
import com.bikkadIT.service.UserServiceI;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserServiceI userserviceI;
	
	@PostMapping("/users")
    ResponseEntity<UserDto> createUser(@Validated@RequestBody UserDto userDto){
        UserDto user = userserviceI.createUser(userDto);
        return new ResponseEntity<UserDto>(user, HttpStatus.CREATED);

    }
    @PutMapping("/users/{id}")
    ResponseEntity<UserDto> updatdUser (@Validated@RequestBody UserDto userdto, @PathVariable ("id") Long userId){
        UserDto updteduser = userserviceI.updateUser(userdto, userId);
        return  new ResponseEntity<UserDto>(updteduser ,HttpStatus.CREATED);
    }
    @GetMapping("/users")
    ResponseEntity <PageableResponse<UserDto>> getAllUsers(
    		@RequestParam(value = "pageNumber",defaultValue = "0",required = false)int pageNumber,
    		@RequestParam(value = "pageSize",defaultValue = "10",required = false) int pageSize,
    		@RequestParam(value = "sortBy",defaultValue = "name",required = false) String sortBy ,
    		@RequestParam(value = "sortDire",defaultValue = "asc",required = false) String sortDire
    		
    		){
     PageableResponse<UserDto> allUser = userserviceI.getAllUser(pageNumber,pageSize,sortBy ,sortDire);
     
        return  new ResponseEntity<PageableResponse<UserDto>>(allUser,HttpStatus.OK);

    }
    @GetMapping("/users/{id}")
    ResponseEntity<UserDto> getSingleUser(@PathVariable("id") Long userId){
        UserDto user = userserviceI.getuserById(userId);
        return  new ResponseEntity<UserDto>(user,HttpStatus.OK);
    }
    @GetMapping("/users/email/{email}")
    ResponseEntity<UserDto> getuserByemail(@RequestBody String email){
        UserDto userByEmail = userserviceI.getUserByEmail(email);
       return new ResponseEntity <UserDto> (userByEmail ,HttpStatus.OK);
    }

    @GetMapping("/users/search/{keywords}")
    ResponseEntity <List<UserDto>> searchUserbykeyword(@RequestBody String keywords){
       List<UserDto> word = userserviceI.searchUser(keywords);
       return  new ResponseEntity<List<UserDto>>(word ,HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    ResponseEntity<ApiResponse> deleteUserById(@PathVariable ("id") Long userId){
        userserviceI.deleteUser(userId);
        return  new ResponseEntity(new ApiResponse( "user Deleted successfully",true), HttpStatus.OK);
    }
}
