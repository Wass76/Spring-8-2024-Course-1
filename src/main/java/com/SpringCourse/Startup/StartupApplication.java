package com.SpringCourse.Startup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
@RequestMapping("/hello")
public class StartupApplication {

	@Autowired
	Student student ;
	@Autowired
	Student student2 ;

//	@Value("${")
//	private String courseLevel;

	public static void main(String[] args) {
		SpringApplication.run(StartupApplication.class, args);
	}

	@GetMapping()
	public List<Student>  hello() {
//		Map<String, String> map = new HashMap<>();
//		map.put("name", "Java");
//		map.put("surname", "Spring");
//		map.put("version", "17");
////		System.out.println(map.get("name"));
//		return map;
//				1,
//				"Wassem" ,
//				LocalDate.of(2023 , 11 , 20),
//				50,
//				1
//		);
		student.setId(1);
		student.setMark(50);
		student.setAge(1);
		student.setBirthdate(LocalDate.now());
		student.setName("Wassem");

		student2.setId(2);
		student2.setMark(80);
		student2.setAge(25);
		student2.setBirthdate(LocalDate.now());
		student2.setName("Tammam");
		return List.of( student , student2);
	}

}
