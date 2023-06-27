package com.devmountain.noteApp.configuration;


import com.devmountain.noteApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.ArrayList;

@Configuration
public class Config {

    @Bean
    public PasswordEncoder passwordEncoder(){
        //custom Java Bean
        return new BCryptPasswordEncoder();
    }
}