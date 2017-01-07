package com.selab;

import com.selab.model.Model;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MySpringServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringServiceApplication.class, args);
		Model model = new Model();
		model.execute();
	}
}
