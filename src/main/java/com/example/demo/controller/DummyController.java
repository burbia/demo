package com.example.demo.controller;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DummyController {

    private final UserMapper userMapper;

    @GetMapping("/dummy")
    public String dummy() {

        User user = User.builder()
            .id(1L)
            .name("John Doe")
            .email("john.doe@example.com").build();

        UserDto userDTO = UserMapper.INSTANCE.userToUserDTO(user);

        return userDTO.toString();
    }

    @GetMapping("/dummy2")
    public String dummy2() {

        User user = User.builder()
                .id(2L)
                .name("John Doe")
                .email("john.doe@example.com").build();

        UserDto userDTO = userMapper.userToUserDTO(user);

        return userDTO.toString();
    }
}