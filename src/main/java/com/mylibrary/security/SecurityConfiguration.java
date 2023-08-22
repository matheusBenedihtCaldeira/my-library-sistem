package com.mylibrary.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity.csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        //User routes
                        .requestMatchers(new AntPathRequestMatcher("/login", HttpMethod.POST.name())).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/register/user", HttpMethod.POST.name())).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/index/user", HttpMethod.GET.name())).authenticated()
                        .requestMatchers(new AntPathRequestMatcher("/user/{id}", HttpMethod.GET.name())).authenticated()
                        .requestMatchers(new AntPathRequestMatcher("/delete/user/{id}", HttpMethod.DELETE.name())).authenticated()
                        .requestMatchers(new AntPathRequestMatcher("/update/user/{id}", HttpMethod.PUT.name())).authenticated()
                        //Books routes
                        .requestMatchers(new AntPathRequestMatcher("/register/book", HttpMethod.POST.name())).authenticated()
                        .requestMatchers(new AntPathRequestMatcher("/index/book", HttpMethod.GET.name())).authenticated()
                        .requestMatchers(new AntPathRequestMatcher("/book/{id}", HttpMethod.GET.name())).authenticated()
                        .requestMatchers(new AntPathRequestMatcher("/delete/book/{id}", HttpMethod.DELETE.name())).authenticated()
                        .requestMatchers(new AntPathRequestMatcher("/update/book/{id}", HttpMethod.PUT.name())).authenticated()
                        //Collections routes
                        .requestMatchers(new AntPathRequestMatcher("/create/collection", HttpMethod.POST.name())).authenticated()
                        .requestMatchers(new AntPathRequestMatcher("/index/collection", HttpMethod.GET.name())).authenticated()
                        .requestMatchers(new AntPathRequestMatcher("/collection/{id}", HttpMethod.GET.name())).authenticated()
                        .requestMatchers(new AntPathRequestMatcher("/delete/collection/{id}", HttpMethod.DELETE.name())).authenticated()
                        .requestMatchers(new AntPathRequestMatcher("/update/collection/{id}", HttpMethod.PUT.name())).authenticated()
                        .anyRequest().authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}