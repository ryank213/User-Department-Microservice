package com.quintrix.jfs.usermicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.quintrix.jfs.usermicroservice.VO.ResponseTemplateVO;
import com.quintrix.jfs.usermicroservice.entity.User;
import com.quintrix.jfs.usermicroservice.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User postUser(@RequestBody User user) {
        return userService.postUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserDepartment(@PathVariable("id") Long userId) {
        return userService.getUserDepartment(userId);
    }

}
