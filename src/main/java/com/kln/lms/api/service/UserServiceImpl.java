package com.kln.lms.api.service;

import com.kln.lms.api.model.Course;
import com.kln.lms.api.model.Student;
import com.kln.lms.api.model.User;
import com.kln.lms.api.repository.CourseRepository;
import com.kln.lms.api.repository.StudentRepository;
import com.kln.lms.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

    private  final UserRepository userRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // :Todo login students and lectures
        Student student = studentRepository.findStudentByEmail(email);
        if(student == null){
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        }else {
            log.info("User found in the database");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        student.getEnrolledCourses().forEach(course -> authorities.add(new SimpleGrantedAuthority(course.getName())));
        return new org.springframework.security.core.userdetails.User(student.getEmail(), student.getPassword(), authorities);
    }

    @Override
    public User saveUser(User user) {
        log.info("Saving new {} {}", user.getRole(), user.getName());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Course saveCourse(Course course) {
        log.info("Saving new Course {}", course.getName());
        return courseRepository.save(course);
    }

    @Override
    public Student getStudent(Integer studentId) {
        log.info("Fetching Student {}", studentId);
//        return studentRepository.findById(studentId).get();
        return (Student) userRepository.findUserByIdAndRoleEquals(studentId, "STUDENT");
    }

    @Override
    public List<Student> getAllStudents() {
        log.info("Fetching All Students");
        return studentRepository.findAll();
    }

    @Override
    public void addCourseToStudent(Integer studentId, Integer courseId) {
        Student student = studentRepository.findById(studentId).get();
        Course  course = courseRepository.findById(courseId).get();
        log.info("Adding course {} to student {}", course.getName(), student.getName());
        student.getEnrolledCourses().add(course);
        course.enrollStudent(student);
    }

}
