package ru.kata.spring.boot_security.demo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.services.UserService;

@SpringBootApplication
public class SpringBootSecurityDemoApplication implements ApplicationRunner {

	private final UserService userService;

	public SpringBootSecurityDemoApplication(UserService userService) {
		this.userService = userService;
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityDemoApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		User user = new User();

		user.setUsername("user");
		user.setEmail("user@gmail.com");
		user.setPassword("user");

		User admin = new User();

		admin.setUsername("admin");
		user.setEmail("admin@gmail.com");
		admin.setPassword("admin");

		userService.saveUser(user);
		userService.saveUser(admin);

		System.out.println("GET USER LIST: " + userService.getUserList());
	}
}
