package com.selab;

import com.selab.model.Entity.Ad;
import com.selab.model.Model;
import com.selab.model.repository.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class MySpringServiceApplication {
    @Autowired
    private AdRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(MySpringServiceApplication.class, args);
	}

	@PostConstruct
    public void init() {
        Model model = new Model(repository);
        model.execute();
    }
}
