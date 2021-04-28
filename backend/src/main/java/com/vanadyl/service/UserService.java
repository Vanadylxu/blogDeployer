package com.vanadyl.service;

import com.vanadyl.entity.User;

public interface UserService {
    User findUserByUsernameAndPassword(String username, String password);
}
