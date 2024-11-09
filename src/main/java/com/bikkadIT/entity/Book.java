package com.bikkadIT.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
public class Book {

    @javax.persistence.Id
    private String Id;
    private String name;
    private String Author;

}
