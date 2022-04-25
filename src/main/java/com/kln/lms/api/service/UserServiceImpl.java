package com.kln.lms.api.service;

import com.kln.lms.api.model.Course;
import com.kln.lms.api.model.Lecturer;
import com.kln.lms.api.model.Student;
import com.kln.lms.api.model.User;
import com.kln.lms.api.repository.CourseRepository;
import com.kln.lms.api.repository.LecturerRepository;
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

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    private final LecturerRepository lecturerRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findUserByEmail(email);

        if(user == null){
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        }else {
            log.info("User found in the database");
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

        String role = user.getRole();

        if(role.equals("STUDENT")){
            Student student = studentRepository.findStudentByEmail(email);
            student.getEnrolledCourses().forEach(course -> authorities.add(new SimpleGrantedAuthority(course.getName())));
        }else if(role == "LECTURER"){
            Lecturer lecturer = lecturerRepository.findLecturerByEmail(email);
        }

        authorities.add(new SimpleGrantedAuthority(role));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }

    public User saveUser(User user) {
        log.info("Saving new {} {}", user.getRole(), user.getName());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }



//    public Student getStudent(Integer studentId) {
//        log.info("Fetching Student {}", studentId);
////        return studentRepository.findById(studentId).get();
//        return (Student) userRepository.findUserByIdAndRoleEquals(studentId, "STUDENT");
//    }
//
//    public void addCourseToStudent(Integer studentId, Integer courseId) {
//        Student student = studentRepository.findById(studentId).get();
//        Course  course = courseRepository.findById(courseId).get();
//        log.info("Adding course {} to student {}", course.getName(), student.getName());
//        student.getEnrolledCourses().add(course);
//        course.enrollStudent(student);
//    }

}
