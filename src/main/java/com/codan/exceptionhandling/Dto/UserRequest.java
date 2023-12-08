package com.codan.exceptionhandling.Dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {
    @NotNull(message = "username shouldn't be null !!")
    private String name;
    @Email(message = "invalid email id !!")
    private String email;
    @NotNull
    @Pattern(regexp = "^\\d{10}$", message = "invalid mobile no !!")
    private String mobile;
    private String gender;
    @Min(18)
    @Max(60)
    private int age;
    @NotBlank(message = "nationality should not be blank !!")
    private String nationality;
}
