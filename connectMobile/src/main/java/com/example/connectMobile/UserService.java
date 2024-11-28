package com.example.connectMobile;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User register(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return userRepository.save(user);
    }

    public User login(UserDto userDto) {
        User user = userRepository.findByUsername(userDto.getName());
        if (user != null) {
            if(passwordEncoder.matches(userDto.getPassword(), user.getPassword())){
                return user;
            }
        }
        return null;
    }
}
