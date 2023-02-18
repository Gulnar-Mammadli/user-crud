package com.mammadli.user_crud.db.dto;

import lombok.Data;

@Data
public class UserGetDto {

    private String id;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;

}
