package com.db.kursach.configurations;

import com.db.kursach.services.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;




@EnableWebSecurity
@RequiredArgsConstructor
@Configuration
public class SecurityConfig{
    private final CustomUserDetailsService userDetailsService;
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .requestMatchers("/","/employees", "/employee/**", "/orders", "/order/**", "/products","/product/**", "/suppliers", "/supplier/**","/registration", "/views", "/deliveries", "/delivery/**" )
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
        return http.build();
    }

    /*@Bean
    public AuthenticationManager configure(AuthenticationManagerBuilder auth) throws Exception {
         auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }*/
    /*@Bean
    public AuthenticationManager authenticationManagerBean(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }*/
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationManagerBuilder auth ) throws Exception {
        return auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder()).and().build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(8);
    }


}