package com.bikkadIT.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="Users")
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(name="user_name")
    private String name;

    @Column(name="user_email",unique = true)
    private String email;

    @Column(name="user_password",length = 10)
    private String password;

    private String gender;

    @Column(length = 1000)
    private String about;

    @Column(name="user_image_name")
    private String ImageName;
}
