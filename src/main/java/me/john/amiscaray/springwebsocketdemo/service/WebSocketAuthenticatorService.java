package me.john.amiscaray.springwebsocketdemo.service;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class WebSocketAuthenticatorService {

    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authManager;

    public WebSocketAuthenticatorService(PasswordEncoder passwordEncoder, AuthenticationManager authManager) {
        this.passwordEncoder = passwordEncoder;
        this.authManager = authManager;
    }

    public UsernamePasswordAuthenticationToken getAuthenticatedOrFail(String username, String password) throws AuthenticationException {

        // Check the username and password are not empty
        if (username == null || username.trim().isEmpty()) {
            throw new AuthenticationCredentialsNotFoundException("Username was null or empty.");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new AuthenticationCredentialsNotFoundException("Password was null or empty.");
        }
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                username,
                password,
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
        );

        // verify that the credentials are valid
        authManager.authenticate(token);

        // Erase the password in the token after verifying it because we will pass it to the STOMP headers.
        token.eraseCredentials();

        return token;
    }
}