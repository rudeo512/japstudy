package me.caru.jpastudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import me.caru.jpastudy.repository.CustomJpaRepositoryImpl;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImpl.class)
@EnableJpaAuditing(auditorAwareRef="accountAuditorAware")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
