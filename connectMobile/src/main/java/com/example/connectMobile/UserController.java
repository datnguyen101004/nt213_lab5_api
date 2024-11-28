package com.example.connectMobile;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
@CrossOrigin("*")
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody UserDto user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody UserDto user) {
        return userService.login(user);
    }
}