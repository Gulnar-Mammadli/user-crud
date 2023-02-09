package com.mammadli.user_crud.mapper;

import com.mammadli.user_crud.db.dto.UserDto;
import com.mammadli.user_crud.db.dto.UserGetDto;
import com.mammadli.user_crud.db.dto.UserUpdateDto;
import com.mammadli.user_crud.db.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;


@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface UserMapper {

    User mapToUser(UserDto userDto);

    User fromUserUpdateDto(UserUpdateDto userUpdateDto);

    UserUpdateDto mapToUserUpdateDto(User user);

    UserGetDto mapToUserGetDto(User user);

}
