package com.mammadli.user_crud.db.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String name;
    private String surname;
    private String email;
    private String phoneNumber;

    @Column(unique = true)
    private String userName;

    private String password;
}
