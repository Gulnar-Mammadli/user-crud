package com.mammadli.user_crud.services.impl;

import com.mammadli.user_crud.db.dto.UserDto;
import com.mammadli.user_crud.db.dto.UserGetDto;
import com.mammadli.user_crud.db.dto.UserUpdateDto;
import com.mammadli.user_crud.db.entity.User;
import com.mammadli.user_crud.db.repository.UserRepository;
import com.mammadli.user_crud.mapper.UserMapper;
import com.mammadli.user_crud.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServicesImpl implements UserServices {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public User create(UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        user.setUserName(user.getName().concat(".").concat(user.getSurname()));
        return userRepository.save(user);
    }

    @Override
    public User update(String userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            UserUpdateDto userDto = userMapper.mapToUserUpdateDto(user.get());
            return userRepository.save(userMapper.fromUserUpdateDto(userDto));
        }
        return null;
    }

    @Override
    public UserGetDto getUser(String userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.map(userMapper::mapToUserGetDto).orElse(null);
    }

    @Override
    public Void deleteUser(String userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            userRepository.deleteById(user.get().getId());
            userRepository.save(user.get());
        }
        return null;
    }
}
