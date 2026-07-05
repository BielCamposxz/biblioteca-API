package com.Livraria.livraria;

import com.Livraria.livraria.service.user.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LivrariaApplication {


	public static void main(String[] args) {
		SpringApplication.run(LivrariaApplication.class, args);
	}

}
