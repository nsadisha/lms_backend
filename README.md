# Learning Management Service (Java + Spring Boot)

**Learning Management Service** is a Java-based web application built with Spring Boot. It serves as a platform for managing and delivering educational content, courses, and resources online. This application has been developed as part of a course module in Software Construction at the University of Kelaniya.

## API Endpoints

### Courses

- **Get All Courses**:
  - Endpoint: `/courses/all`
  - Method: `GET`
  - Description: Get a list of all available courses.

- **Get Course Details**:
  - Endpoint: `/courses/{courseId}`
  - Method: `GET`
  - Description: Get detailed information about a specific course.

- **Add New Course**:
  - Endpoint: `/courses/add`
  - Method: `POST`
  - Description: Add a new course to the system.

- **Get Course Announcements**:
  - Endpoint: `/courses/{courseId}/announcements`
  - Method: `GET`
  - Description: Get announcements related to a specific course.

### Students

- **Get Student Details**:
  - Endpoint: `/students/{studentId}`
  - Method: `GET`
  - Description: Get details of a specific student.

- **Enroll Student to Course**:
  - Endpoint: `/students/{studentId}/enroll/{courseId}`
  - Method: `POST`
  - Description: Enroll a student in a specific course.

- **Unenroll Student from Course**:
  - Endpoint: `/students/{studentId}/unenroll/{courseId}`
  - Method: `POST`
  - Description: Remove a student from a course.

- **Get Enrolled Courses for Student**:
  - Endpoint: `/students/{studentId}/courses`
  - Method: `GET`
  - Description: Get a list of courses in which a student is enrolled.

- **Get Marks for Course**:
  - Endpoint: `/students/{studentId}/course/{courseId}`
  - Method: `GET`
  - Description: Get marks for a specific course and student.

### Lecturers

- **Get Lecturer Details**:
  - Endpoint: `/lecturers/{lecturerId}`
  - Method: `GET`
  - Description: Get details of a specific lecturer.

- **Get Enrolled Students for Course**:
  - Endpoint: `/lecturers/{courseId}/students`
  - Method: `GET`
  - Description: Get a list of students enrolled in a specific course.

- **Get Enrolled Students' Marks for Course**:
  - Endpoint: `/lecturers/{courseId}/students/marks`
  - Method: `GET`
  - Description: Get marks of enrolled students in a specific course.

- **Assign Marks to Student**:
  - Endpoint: `/lecturers/{courseId}/student/{studentId}/mark/{marks}`
  - Method: `POST`
  - Description: Assign marks to a student in a specific course.

- **Post Announcement for Course**:
  - Endpoint: `/lecturers/{courseId}/announcement`
  - Method: `POST`
  - Description: Post an announcement for a specific course.

- **Get Conducting Courses for Lecturer**:
  - Endpoint: `/lecturers/{lecturerId}/courses`
  - Method: `GET`
  - Description: Get a list of courses conducted by a lecturer.

### Users

- **User Signup**:
  - Endpoint: `/signup`
  - Method: `POST`
  - Description: Sign up a new user.

- **Refresh Token**:
  - Endpoint: `/refresh_token`
  - Method: `GET`
  - Description: Refresh authentication tokens.

## Installation

To run the Learning Management Service on your server, follow these steps:

1. **Clone this Repository**: `git clone https://github.com/nsadisha/learning-management-service.git`

2. **Database Configuration**: Set up a database (MySQL) and configure the connection in `application.properties` or `.yml` files.

3. **Build and Run**: Build the project using Maven or Gradle and run it on your server.

4. **Access the Application**: Access the application in your web browser by navigating to `http://localhost:8080`.

## Usage

- Please refer to the API endpoints above for details on how to use each service.

## Contributing

We welcome contributions from the community. 

## Acknowledgments

- This Learning Management Service was developed for educational purposes as part of the Software Construction course module at the University of Kelaniya.

- Special thanks to the Java and Spring Boot communities for their valuable resources and support.

## Contact

If you have any questions, suggestions, or feedback related to this assignment for the Software Construction course module at the University of Kelaniya, please feel free to reach out to us.
