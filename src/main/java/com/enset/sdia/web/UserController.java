package com.enset.sdia.web;

import com.enset.sdia.entity.User;
import com.enset.sdia.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private IUserService userService;
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return userService.getUser(id);
    }
    @PostMapping("/add")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }
}
