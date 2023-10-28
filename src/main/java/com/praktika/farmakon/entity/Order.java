package com.praktika.farmakon.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer Number;
    @OneToMany
    private Set<Preparation> preparation;
    @ManyToOne
    private User user;
}
