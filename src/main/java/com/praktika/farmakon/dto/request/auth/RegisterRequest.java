package com.praktika.farmakon.dto.request.auth;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class RegisterRequest {
    @Email
    @NotNull(message = "Email cannot be null")
    private String email;
    @NotNull(message = "Password cannot be null")
    @Size(min = 6, max = 16, message = "Length should be between 6 to 16")
    private String  password;
    @NotNull(message = "Name cannot be null")
    private String name;
    private String surname;
    private Long roleId;
    @Past
    @NotNull(message = "Birthday cannot be null. Use \"yyyy-mm-dd\" format")
    private Date dateOfBirthday;
}
