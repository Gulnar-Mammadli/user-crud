package com.mammadli.user_crud.api;

import com.mammadli.user_crud.db.dto.UserDto;
import com.mammadli.user_crud.db.dto.UserGetDto;
import com.mammadli.user_crud.db.dto.UserUpdateDto;
import com.mammadli.user_crud.db.entity.User;
import com.mammadli.user_crud.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserServices userServices;

    @PostMapping
    ResponseEntity<User> create(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userServices.create(userDto));
    }

    @PutMapping("/userId/{userId}")
    ResponseEntity<User> update(@RequestBody UserUpdateDto userUpdateDto, @PathVariable String userId){
        return ResponseEntity.ok(userServices.update(userUpdateDto,userId));
    }

    @GetMapping("/userId/{userId}")
    ResponseEntity<UserGetDto> getUser(@PathVariable String userId){
        return ResponseEntity.ok(userServices.getUser(userId));
    }

    @DeleteMapping("/userId/{userId}")
    ResponseEntity<Void> deleteUser(@PathVariable String userId){
        return ResponseEntity.ok(userServices.deleteUser(userId));
    }
}
