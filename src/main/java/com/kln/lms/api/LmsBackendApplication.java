package com.kln.lms.api;

import com.kln.lms.api.model.Course;
import com.kln.lms.api.model.Lecturer;
import com.kln.lms.api.model.Student;
import com.kln.lms.api.service.CourseServiceImpl;
import com.kln.lms.api.service.LecturerServiceImpl;
import com.kln.lms.api.service.StudentServiceImpl;
import com.kln.lms.api.service.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;

@SpringBootApplication
@Configuration
public class LmsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(LmsBackendApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(StudentServiceImpl studentService, UserServiceImpl userService,
						  CourseServiceImpl courseService){
		return args -> {

			userService.saveUser(new Student(null, "Hasini", "Hasini@gmail.com", "123", "STUDENT"));
			userService.saveUser(new Student(null, "Sadisha", "Sadisha@gmail.com", "123", "STUDENT"));
			userService.saveUser(new Student(null, "Tharushi", "Tharushi@gmail.com", "123", "STUDENT"));

			userService.saveUser(new Lecturer(null, "Amara", "Amara@gmail.com", "123", "LECTURER"));
			userService.saveUser(new Lecturer(null, "Kasun", "Kasun@gmail.com", "123", "LECTURER"));

			userService.saveUser(new Lecturer(null, "Admin", "admin@admin.com", "123", "ADMIN"));

			courseService.saveCourse(new Course(null, "SENG 22212", "Software Architecture", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", null, new HashSet<>(), new HashSet<>()), "Amara@gmail.com");
			courseService.saveCourse(new Course(null, "SENG 12243", "Software Construction", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", null, new HashSet<>(), new HashSet<>()), "Amara@gmail.com");
			courseService.saveCourse(new Course(null, "SENG 12222", "Computer Network", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum", null, new HashSet<>(), new HashSet<>()), "Kasun@gmail.com");
			courseService.saveCourse(new Course(null, "SENG 12232", "Mobile Application Development", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", null, new HashSet<>(), new HashSet<>()), "Kasun@gmail.com");

			studentService.addStudentToCourse(1,1);
			studentService.addStudentToCourse(1,2);
			studentService.addStudentToCourse(2,1);
			studentService.addStudentToCourse(3,4);

		};
	}

}
