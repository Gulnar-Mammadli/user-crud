package com.mammadli.user_crud.services.impl;

import com.mammadli.user_crud.db.dto.UserDto;
import com.mammadli.user_crud.db.dto.UserGetDto;
import com.mammadli.user_crud.db.dto.UserUpdateDto;
import com.mammadli.user_crud.db.entity.User;
import com.mammadli.user_crud.db.repository.UserRepository;
import com.mammadli.user_crud.mapper.UserMapper;
import com.mammadli.user_crud.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServicesImpl implements UserServices {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public User create(UserDto userDto) {

        User user = userMapper.mapToUser(userDto);
        user.setUserName(user.getName().concat(".").concat(user.getSurname()));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User update(UserUpdateDto userUpdateDto, String userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            User updatedUser = User.builder()
                    .id(userId)
                    .name(user.get().getName())
                    .surname(user.get().getSurname())
                    .userName(user.get().getUserName())
                    .email(userUpdateDto.getEmail())
                    .phoneNumber(userUpdateDto.getPhoneNumber())
                    .password(passwordEncoder.encode(userUpdateDto.getPassword()))
                    .build();
            return userRepository.save(updatedUser);
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
