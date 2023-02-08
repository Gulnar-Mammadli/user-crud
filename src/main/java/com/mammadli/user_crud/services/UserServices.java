package com.mammadli.user_crud.services;

import com.mammadli.user_crud.db.dto.UserDto;
import com.mammadli.user_crud.db.entity.User;

public interface UserServices {

    User create(UserDto userDto);

    User update(String userId);

    User getUser(String userId);

    Void deleteUser(String userId);
}
