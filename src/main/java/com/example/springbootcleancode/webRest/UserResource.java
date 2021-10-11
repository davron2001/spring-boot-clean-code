package com.example.springbootcleancode.webRest;

import com.example.springbootcleancode.domain.User;
import com.example.springbootcleancode.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserResource {
    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity create(User user) {
        if (!checkPasswordLength(user.getPassword())) {
            return new ResponseEntity("Parol uzunligi 4 dan kichkina.", HttpStatus.BAD_REQUEST);
        }
        if (userService.checkUserName(user.getUserName())) {
            return new ResponseEntity("Bu User Oldin ruyhatdan utgan.", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(userService.create(user));
    }

    private Boolean checkPasswordLength(String password) {
        return password.length() > 4;
    }
}
