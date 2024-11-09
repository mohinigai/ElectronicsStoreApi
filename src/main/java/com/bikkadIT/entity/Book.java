package com.bikkadIT.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Book {
     @Id
    private String Id;
    private String name;
    private String Author;
    private String price;

}
