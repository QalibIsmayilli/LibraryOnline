package com.company.library.service;

import com.company.library.dto.UserDto;
import com.company.library.dto.requests.UserSaveRequest;
import com.company.library.exception.GenericException;
import com.company.library.model.User;
import com.company.library.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto createUser(UserSaveRequest userSaveRequest){
        User user = userRepository.save(new User.Builder().username(userSaveRequest.getUsername())
                .password(passwordEncoder.encode(userSaveRequest.getPassword()))
                .email(userSaveRequest.getEmail())
                .role(userSaveRequest.getRole()).build());

        return new UserDto(user.getUsername(),user.getEmail(),user.getRole());
    }

    public User findUserByUsername(String username){
        return userRepository.findUserByUsername(username)
                .orElseThrow(()-> new GenericException(HttpStatus.NOT_FOUND,"user not found by given username")
                );
    }

    public UserDto findUserDtoByUsername(String username){
        User user = findUserByUsername(username);
        return new UserDto(user.getUsername(),user.getEmail(),user.getRole());
    }
}
