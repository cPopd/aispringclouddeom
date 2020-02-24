package com.southwind.repository;

import com.southwind.entity.User;

public interface UserRepositoy {
    public User login(String username, String password);
}
