package com.southwind.controller;

import com.southwind.repository.AdminRepositoy;
import com.southwind.repository.UserRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountHandler {
    @Autowired
    private AdminRepositoy adminRepositoy;
    @Autowired
    private UserRepositoy userRepositoy;

    @GetMapping("/login/{username}/{password}/{type}")
    public Object login(@PathVariable("username") String username,@PathVariable("password") String password,@PathVariable("type") String type){
        Object object=null;
            switch (type){
                case "user":
                    object=userRepositoy.login(username,password);
                    break;
                case "admin":
                    object=adminRepositoy.login(username,password);
                    break;
            }
            return object;
    }

}
