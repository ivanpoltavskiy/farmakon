package com.praktika.farmakon.dto.response.user;

import com.praktika.farmakon.entity.Order;
import lombok.Data;

import javax.persistence.OneToMany;
import java.util.Date;
import java.util.Set;

@Data
public class UserResponse {
    private Long id;
    private String name;
    private String surname;
    private Date dateOfBirthday;
    private Set<Order> order;
    private Integer bonus;
}
