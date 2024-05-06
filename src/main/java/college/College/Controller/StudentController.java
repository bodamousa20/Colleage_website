package college.College.Controller;

import college.College.Model.CourceClass;
import college.College.Model.StudentClass;
import college.College.Reprositry.CourceJpa;
import college.College.Reprositry.StudentJpa;
import college.College.Model.StudentProfileUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/Student")

public class StudentController {
    @Autowired
    StudentJpa studentRepository;

    @Autowired
    private CourceJpa CourceJpa;
    @Autowired
    private CourceJpa courceJpa;


    @GetMapping("gpa/{id}")
    public ResponseEntity<?>getStudentGpaById(@PathVariable int id) {
        Optional<StudentClass> student = studentRepository.findById(id);

        if(student.isEmpty()){
            return ResponseEntity.badRequest().body("Student ID is invalid");

        }

        float gpa = student.get().getAccumulator_gpa();
          return ResponseEntity.ok(gpa);




    }

    @PutMapping("/updateProfile/{id}")
    public ResponseEntity<?> updateProfile(@PathVariable Integer id,  @RequestBody StudentProfileUpdateRequest request) {
        Optional<StudentClass> studentOptional = studentRepository.findById(id);
        if (studentOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Student ID " + id + " is invalid or not present");
        }

        StudentClass student = studentOptional.get();

        // Validate input data
        // Validate age
        if (request.getAge() < 0) {
            return ResponseEntity.badRequest().body("Invalid date ");
        }

        // Validate email format


        // Validate password length
        if (request.getPassword().length() < 6) {
            return ResponseEntity.badRequest().body("password is too short ");
        }

        // Update student details
        student.setName(request.getName()); //name
        student.setAge(request.getAge()); //age
        student.setPassword(request.getPassword()); //password

        studentRepository.save(student);

        return ResponseEntity.ok("Profile updated successfully");
    }

    // Method to validate email format




    @GetMapping("/profile/{id}")
    public Optional<StudentClass> userProfile(@PathVariable int id) {
        return studentRepository.findById(id);
    }

    @GetMapping("/allStudentCourse")
    public List<CourceClass> getStudentCource() {
        return CourceJpa.findAll();
    }


    @PutMapping("/setCourses")
    public ResponseEntity<?> selectCourses(@RequestBody Map<String, Object> requestBody) {
        Integer studentId = (Integer) requestBody.get("student_id");
        List<Integer> courseIds = (List<Integer>) requestBody.get("course_ids");

        // Check if student ID is provided
        if (studentId == null) {
            return ResponseEntity.badRequest().body("Student ID is required in the request body");
        }

        // Check if student exists in the database
        Optional<StudentClass> optionalStudent = studentRepository.findById(studentId);
        if (optionalStudent.isEmpty()) {
            return ResponseEntity.badRequest().body("Student ID is invalid");

        }

        StudentClass student = optionalStudent.get();
        String department = student.getDepartment();


                // Retrieve all courses the student is already enrolled in
        List<CourceClass> enrolledCourses = student.getEnrolledCourses(); // call method i build in student class that return list

        // Retrieve selected courses from database
        List<CourceClass> selectedCourses = courceJpa.findAllById(courseIds);

        // Check if all selected courses exist
        for (Integer courseId : courseIds) {
            boolean exists = selectedCourses.stream().anyMatch(course -> course.getId().equals(courseId));
            Optional<CourceClass> optionalCourse = selectedCourses.stream().filter(course -> course.getId().equals(courseId)).findFirst();
            if (optionalCourse.isPresent()) {
                CourceClass course = optionalCourse.get();
                if (!Objects.equals(course.getDepartment(), department)) {
                    return ResponseEntity.badRequest().body("Course ID " + courseId + " is not in your department");
                }
            }

            if (!exists) {
                return ResponseEntity.badRequest().body("Course ID " + courseId + " is invalid");
            }

        }

        // Add selected courses that are not already enrolled
        for (CourceClass course : selectedCourses) {
            if (!enrolledCourses.contains(course)) {
                enrolledCourses.add(course);
            }
        }

        // Set courses for the student
        student.setEnrolledCourses(enrolledCourses);
        studentRepository.save(student);

        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("success", true);
        responseBody.put("message", "Courses updated successfully for student " + studentId);

        return ResponseEntity.ok(responseBody);
    }



}













