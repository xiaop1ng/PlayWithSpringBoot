package com.xiaoping.service;

import com.xiaoping.entity.User;

public interface UserService {

    public User register(User user);

    public User login(User user);

    public User changePwd(User user);

    public User changeUserInfo(User user);

    public User findByName(String username);

}
