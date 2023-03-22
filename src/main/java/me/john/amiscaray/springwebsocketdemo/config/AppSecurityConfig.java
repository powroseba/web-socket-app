package me.john.amiscaray.springwebsocketdemo.config;

import me.john.amiscaray.springwebsocketdemo.dtos.AppUserDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Set up simplified security settings requiring all requests to be authenticated
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/status", "/index.html", "/webjars/**", "/js/**")
                .permitAll()
                .anyRequest()
                .fullyAuthenticated();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // Tell Spring to ignore securing the handshake endpoint. This allows the handshake to take place unauthenticated
        web.ignoring().antMatchers("/stomp/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(username -> new AppUserDetails(username, passwordEncoder().encode("janekPassword"))).passwordEncoder(passwordEncoder());
    }

    // Create an AuthenticationManager bean to Authenticate users in the ChannelInterceptor
    @Bean
    public AuthenticationManager authManager() throws Exception {
        return this.authenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOriginPatterns("*")
//                         .allowedOrigins("*")
                        .allowedHeaders("*")
                        .allowedMethods("*")
                        .maxAge(3600)
                        .allowCredentials(true)
                        .exposedHeaders("*");
            }
        };
    }

}
