package me.john.amiscaray.springwebsocketdemo.dao;

import me.john.amiscaray.springwebsocketdemo.entities.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepositoryAdapter implements UserRepo {

    private final PasswordEncoder passwordEncoder;
    private final Map<String, User> users = new HashMap<>();

    public UserRepositoryAdapter(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.users.putAll(
                Map.of(
                        "janek", new User("janek", encode("janekPassword")),
                        "adam", new User("adam", encode("adamPassword"))
                )
        );
    }

    @Override
    public User findUserByUsername(String username) {
        return users.get(username);
    }

    @Override
    public User save(User user) {
        return users.put(user.getUsername(), user);
    }

    private String encode(String password) {
        return this.passwordEncoder.encode(password);
    }
}
