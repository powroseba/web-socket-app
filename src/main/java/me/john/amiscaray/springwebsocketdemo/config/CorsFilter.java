package me.john.amiscaray.springwebsocketdemo.config;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CorsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest requestToUse = (HttpServletRequest)servletRequest;
        HttpServletResponse responseToUse = (HttpServletResponse)servletResponse;

        responseToUse.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, requestToUse.getHeader("Origin"));
        responseToUse.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
        filterChain.doFilter(requestToUse,responseToUse);
    }
}
