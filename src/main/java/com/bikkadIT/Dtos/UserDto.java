package com.bikkadIT.Dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
	private Long userId;
   
	@Size(min = 1, max=20 , message = "invalid Name!!")
	private String name;

	@Email(message ="Invalid emails")
	private String email;

	@NotBlank(message ="PassWord Must be Required")
	private String password;
	
    @Size(min =3, max=8)
	private String gender;
  
    @NotBlank(message = "Write Some thing about")
	private String about;

    
	private String ImageName;

}
