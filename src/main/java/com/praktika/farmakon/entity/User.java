package com.praktika.farmakon.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private Date dateOfBirthday;
    @OneToMany
    private Set<Order> order;
    private Integer bonus;
    private String password;
    private String email;
}
