package com.example.assignment_04;

import java.util.Date;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class Assignment04Application {

	public static void main(String[] args) {
		SpringApplication.run(Assignment04Application.class, args);
                Date ab=new Date();
                System.out.println("-----------------------------------"+ab);
	}

}
