package com.mammadli.user_crud.services;

import com.mammadli.user_crud.db.dto.UserDto;
import com.mammadli.user_crud.db.dto.UserGetDto;
import com.mammadli.user_crud.db.dto.UserUpdateDto;
import com.mammadli.user_crud.db.entity.User;

public interface UserServices {

    User create(UserDto userDto);

    User update(UserUpdateDto userUpdateDto,String userId);

    UserGetDto getUser(String userId);

    Void deleteUser(String userId);
}
