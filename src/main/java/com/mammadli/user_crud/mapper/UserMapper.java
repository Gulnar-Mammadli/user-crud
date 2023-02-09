package com.mammadli.user_crud.mapper;

import com.mammadli.user_crud.db.dto.UserDto;
import com.mammadli.user_crud.db.dto.UserGetDto;
import com.mammadli.user_crud.db.entity.User;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {

    User mapToUser(UserDto userDto);

    UserGetDto mapToUserGetDto(User user);

}
