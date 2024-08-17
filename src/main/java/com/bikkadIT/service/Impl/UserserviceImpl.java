package com.bikkadIT.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bikkadIT.Dtos.PageableResponse;
import com.bikkadIT.Dtos.UserDto;
import com.bikkadIT.constant.AppConstant;
import com.bikkadIT.entity.User;
import com.bikkadIT.excepation.ResourceNotFoundExcption;
import com.bikkadIT.helper.Helper;
import com.bikkadIT.repository.UserRepository;
import com.bikkadIT.service.UserServiceI;

@Service
public class UserserviceImpl implements UserServiceI {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.mapper.map(userDto, User.class);
		User createuser = this.userRepository.save(user);
		return this.mapper.map(createuser, UserDto.class);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Long userId) {
		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundExcption(AppConstant.USER_NOT_FOUND));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		user.setImageName(userDto.getImageName());
		User updateduser = userRepository.save(user);
		return mapper.map(updateduser, UserDto.class);
	}

	@Override
	public Void deleteUser(Long userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundExcption(AppConstant.USER_NOT_FOUND));
		userRepository.delete(user);

		return null;
	}

	@Override
	public PageableResponse<UserDto> getAllUser(int pageNumber, int pageSize, String sortBy, String sortDire) {

		Sort sort = (sortDire.equalsIgnoreCase("desc")) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
		Page<User> page = userRepository.findAll(pageable);

		PageableResponse<UserDto> response = Helper.getPageableResponse(page, UserDto.class);
		return response;
	}

	@Override
	public UserDto getuserById(Long UserId) {
		User user = this.userRepository.findById(UserId)
				.orElseThrow(() -> new ResourceNotFoundExcption(AppConstant.USER_NOT_FOUND));
		return mapper.map(user, UserDto.class);
	}

	@Override
	public UserDto getUserByEmail(String email) {

		User user = userRepository.findByEmail(email)
				.orElseThrow(() -> new ResourceNotFoundExcption(AppConstant.USER_NOT_FOUND));

		return mapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> searchUser(String keywords) {
		List<User> users = userRepository.findByNameContaining(keywords);
		List<UserDto> dtosList = users.stream().map(user -> mapper.map(user, UserDto.class))
				.collect(Collectors.toList());
		return dtosList;
	}

	private UserDto entityToDto(User savedUser) {

//        UserDto userDto = UserDto.builder().userId(savedUser.getUserId())
//                .name(savedUser.getName())
//                .email(savedUser.getEmail())
//                .password(savedUser.getPassword())
//                .about(savedUser.getAbout())
//                .gender(savedUser.getGender())
//                .ImageName(savedUser.getImageName())
//                .build();

		return mapper.map(savedUser, UserDto.class);
	}

	private User DtoToentity(UserDto userDto) {
//        User user = User.builder().userId(userDto.getUserId())
//                .name(userDto.getName())
//                .email(userDto.getEmail())
//                .password(userDto.getPassword())
//                .about(userDto.getAbout())
//                .gender(userDto.getGender())
//                .ImageName(userDto.getImageName()).build();

		return mapper.map(userDto, User.class);

	}
}
