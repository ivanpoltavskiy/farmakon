package com.praktika.farmakon.dto.response.user;

import com.praktika.farmakon.entity.Order;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserResponse {
    private Long id;
    private String name;
    private String surname;
    private Date dateOfBirthday;
    private List<Order> order;
    private Integer bonus;
}
