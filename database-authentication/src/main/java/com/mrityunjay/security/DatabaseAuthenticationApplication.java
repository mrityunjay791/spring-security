package com.mrityunjay.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.mrityunjay.security.model.User;
import com.mrityunjay.security.repository.UserRepository;

@SpringBootApplication
public class DatabaseAuthenticationApplication implements CommandLineRunner {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;


	public static void main(String[] args) {
		SpringApplication.run(DatabaseAuthenticationApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		userRepository.save(new User("Mrityunjay", bCryptPasswordEncoder.encode("Abc@123")));
		
	}

}
