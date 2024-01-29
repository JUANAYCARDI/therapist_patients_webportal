package com.psi.satrello.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

    // Allowed endpoints from spring security to make requests
    private static final String[] WHITE_LIST_URLS = {
            "/therapist",
            "/therapist/patients",
            "/register",
            "/register/admin",
            "/role",
            "/therapist/personalid/**",
            "/therapist/uuid/**",
            "/patients",
            "/patients/all/**",
            "/activity",
            "/activity/add",
            "/activity/all",
            "/patient/home",
            "/patient/profile"

    };

    // Standard used to encrypt the user password
    @Bean
    public PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder(11);
    }

    // Configuration of spring security for building and requests actions
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers(WHITE_LIST_URLS).permitAll()
                .and()
                .headers().frameOptions().sameOrigin();

        return http.build();
    }
}