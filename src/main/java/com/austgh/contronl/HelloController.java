package com.austgh.contronl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
//@RestController:@ResponseBody和@Controller
public class HelloController {
    @GetMapping("hello.action")
    public String hello(){
        return "Hello Spring Boot";
    }
}
