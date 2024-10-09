package com.bikkadIT.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {
    @Id
    private String title;
    private String Descripation;
}
