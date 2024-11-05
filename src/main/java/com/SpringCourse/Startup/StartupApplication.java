package com.SpringCourse.Startup;

import com.SpringCourse.Startup.Security.auth.AuthenticationService;
import com.SpringCourse.Startup.Security.auth.RegisterRequest;
import com.SpringCourse.Startup.Security.user.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.SpringCourse.Startup.Security.user.Role.*;

@SpringBootApplication
public class StartupApplication {

	public static void main(String[] args) {
		SpringApplication.run(StartupApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService service
	) {
		return args -> {
			var admin = RegisterRequest.builder()
					.firstname("admin")
					.lastname("admin")
					.email("admin@admin.com")
					.password("admin")
					.role(ADMIN)
					.build();
			System.out.println("admin token "  + service.register(admin).getToken());
			var user = RegisterRequest.builder()
					.firstname("admin")
					.lastname("admin")
					.email("user@admin.com")
					.password("admin")
					.role(USER)
					.build();
			System.out.println("user token "  + service.register(user).getToken());
			var manager = RegisterRequest.builder()
					.firstname("admin")
					.lastname("admin")
					.email("manager@admin.com")
					.password("admin")
					.role(Manager)
					.build();
			System.out.println("manager token "  + service.register(manager).getToken());
		};
	}
}
