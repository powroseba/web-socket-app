package me.john.amiscaray.springwebsocketdemo.dao;

import me.john.amiscaray.springwebsocketdemo.entities.User;

public interface UserRepo {

    User findUserByUsername(String username);
    User save(User user);

}
