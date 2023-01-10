package com.austgh.contronl;

import com.austgh.entity.User;
import com.austgh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestControllerAdvice
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/findById/{id}")
    public User findById(@PathVariable("id") Integer id) {
        return userService.selectById(id);
    }
}
