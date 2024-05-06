package college.College.Controller;

import college.College.Model.*;
import college.College.Reprositry.AdminJpa;
import college.College.Reprositry.CourceJpa;
import college.College.Reprositry.DoctorJpa;
import college.College.Reprositry.StudentJpa;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    StudentJpa studentJpa;
    @Autowired
    DoctorJpa doctorJpa;
    @Autowired
    CourceJpa courceJpa;

    @Autowired
    AdminJpa adminJpa;



// Create Student

    @PostMapping("/addStudent")
    public ResponseEntity<?> adminStudentCreate (
            @Validated @RequestBody StudentClass request) {
        try {
            StudentClass newStudent = new StudentClass();
            String email = request.getEmail();
            int id = request.getId();


            // Check if email already exists
            StudentClass existingDoctorByEmail = studentJpa.findByEmail(email);
            if(existingDoctorByEmail != null){
                return ResponseEntity.badRequest().body("The email is already taken. Please try another one.");
            }

            // Check if ID already exists
            StudentClass existingDoctorById = studentJpa.findById(id).orElse(null);
            if(existingDoctorById != null){
                return ResponseEntity.badRequest().body("The ID is already taken. Please try another one.");
            }
            newStudent.setAccumulator_gpa(request.getAccumulator_gpa());
            newStudent.setAge(request.getAge());
            newStudent.setEmail(request.getEmail());
            newStudent.setName(request.getName());
            newStudent.setPassword(request.getPassword());
            newStudent.setDepartment(request.getDepartment());
            newStudent.setLevel(request.getLevel());
            newStudent.setSsn(request.getSsn());
            newStudent.setGender(request.getGender());
            newStudent.setId(request.getId());
            // Save the new student to the database

            StudentClass savedStudent = studentJpa.save(newStudent);
            return new ResponseEntity<>(savedStudent, HttpStatus.CREATED); // return Crate student to result
        } catch (Exception e) {
            // If an error occurs during student creation, return an error response with appropriate status code
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
        //DELETE STUDENT
        @DeleteMapping("/deleteStudent/{id}")
        public ResponseEntity<?> adminStudentDelete (
        @PathVariable int id) {
            try {
                Optional<StudentClass> Student = studentJpa.findById(id);
                if (Student.isEmpty()) {
                    return ResponseEntity.internalServerError().body("ID Value is invalid ");


                }
                studentJpa.delete(Student.get());
                return ResponseEntity.ok().body("Deleted successfully");

            } catch (Exception e) {
                // If an error occurs during student creation, return an error response with appropriate status code
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        // UPDATE Student
    /*  @PutMapping("/updateStudent/{id}")
    public ResponseEntity<?> adminStudentUpdate( @PathVariable int id ,@RequestBody StudentClass updateData){
        Optional<StudentClass> Student = Optional.ofNullable(studentJpa.findById(id).
                orElseThrow(() -> new ResourceAccessException("Student not found with id " + id)));
        StudentClass updateStudent = Student.get();
          updateStudent.setAccumulator_gpa(updateData.getAccumulator_gpa());
          updateStudent.setAge(updateData.getAge());
          updateStudent.setEmail(updateData.getEmail());
          updateStudent.setName(updateData.getName());
          updateStudent.setPassword(updateData.getPassword());
          updateStudent.setDepartment(updateData.getDepartment());
          updateStudent.setLevel(updateData.getLevel());
          updateStudent.setSsn(updateData.getSsn());
          updateStudent.setGender(updateData.getGender());
          StudentClass savedStudent = studentJpa.save(updateStudent);

          return ResponseEntity.ok().body(savedStudent);

      }
      */


      // CREATE DOCTOR
    @PostMapping("/createDoctor")
    public ResponseEntity<?> adminDoctorCreate(@Validated @RequestBody DoctorClass request){
        try {
           String email = request.getEmail();
            int id = request.getId();


            // Check if email already exists
            DoctorClass existingDoctorByEmail = doctorJpa.findByEmail(email);
            if(existingDoctorByEmail != null){
                return ResponseEntity.badRequest().body("The email is already taken. Please try another one.");
            }

            // Check if ID already exists
            DoctorClass existingDoctorById = doctorJpa.findById(id).orElse(null);
            if(existingDoctorById != null){
                return ResponseEntity.badRequest().body("The ID is already taken. Please try another one.");
            }
            DoctorClass newDoctor = new DoctorClass();
            newDoctor.setEmail(request.getEmail());
            newDoctor.setName(request.getName());
            newDoctor.setPassword(request.getPassword());
            newDoctor.setSsn(request.getSsn());
            newDoctor.setGender(request.getGender());
            newDoctor.setId(request.getId());
            newDoctor.setAge(request.getAge());
            newDoctor.setSalary(request.getSalary());
            // Save the new student to the database

            DoctorClass savedDoctor = doctorJpa.save(newDoctor);
            return new ResponseEntity<>(savedDoctor, HttpStatus.CREATED); // return Crate student to result
        } catch (Exception e) {
            // If an error occurs during student creation, return an error response with appropriate status code
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //DELETE DOCTOR
    @DeleteMapping("/DeleteDoctor/{id}")
    public ResponseEntity<?> adminDeleteDoctor (
            @PathVariable int id) {
        try {
            Optional<DoctorClass> Doctor = doctorJpa.findById(id);
            if (Doctor.isEmpty()) {
                return ResponseEntity.internalServerError().body("ID of doctor is invalid or not present ");

            }
            doctorJpa.delete(Doctor.get());
            return ResponseEntity.ok().body("Deleted successfully");

        } catch (Exception e) {
            // If an error occurs during student creation, return an error response with appropriate status code
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //ADD COURCES
    @PostMapping("/addCourse")
    public List<CourceClass> adminAddCourse(@Valid @RequestBody List<CourceClass> newCourses){
        List<CourceClass> SavedCourse = courceJpa.saveAll(newCourses);
        return SavedCourse ;
    }
 // Delete course by id
    @DeleteMapping("/deleteCourse/{id}")
    public  ResponseEntity<String> adminDeleteCourse(@PathVariable int id ){
        Optional<CourceClass> SelectedCourse = courceJpa.findById(id);
        if(SelectedCourse.isPresent()) {
            CourceClass deletedClass = SelectedCourse.get();
            courceJpa.delete(deletedClass);
             return ResponseEntity.status(HttpStatus.OK).body("Course with ID " + id + " has been deleted.");
        }
        else {
            return ResponseEntity.internalServerError().body("ID is invalid can not deleted ");

        }


    }

    // ASSIGN COURCES TO DOCTOR BY DOCTOR ID
    @PostMapping("/{doctorId}/courses/{courseId}")
    public ResponseEntity<String> assignCourseToDoctor(@PathVariable int doctorId, @PathVariable int courseId) {
        DoctorClass doctor = doctorJpa.findById(doctorId).orElse(null);
        CourceClass course = courceJpa.findById(courseId).orElse(null);

        if (doctor == null || course == null) {
            return ResponseEntity.badRequest().body("Doctor or course not found.");
        }
        if (doctor.getCourses().contains(course)) {
            return ResponseEntity.badRequest().body("Doctor already has this course.");
        }
        if (doctor.getCourses().size() >= 3) {
            return ResponseEntity.badRequest().body("Doctor already has maximum number of courses.");
        }

        doctor.getCourses().add(course);
        doctorJpa.save(doctor);

        return ResponseEntity.ok("Course assigned successfully.");


    }
    @PostMapping("/releaseGrade")
    public ResponseEntity<?> relaseGrade(@RequestBody GradeClass grades){
        Optional<StudentClass> student = studentJpa.findById(grades.getId());
        if(student.isEmpty()){
           return ResponseEntity.badRequest().body("Student id is invalid or not present ");
        }

            StudentClass stu = student.get();
            stu.setAccumulator_gpa(grades.getGpa());
            studentJpa.save(stu);



        return ResponseEntity.badRequest().body("Student grade is set to id " + grades.getId() );

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProfile(@PathVariable Integer id,  @RequestBody AdminClass request) {
        Optional<AdminClass> admin = adminJpa.findById(id);
        if (admin.isEmpty()) {
            return ResponseEntity.badRequest().body("admin ID " + id + " is invalid or not present");
        }

        AdminClass admins = admin.get();

        // Validate input data
        // Validate age


        // Validate email format


        // Validate password length
        if (request.getPassword().length() < 6) {
            return ResponseEntity.badRequest().body("password is too short ");
        }

        // Update student details
        admins.setName(request.getName());
        admins.setPassword(request.getPassword());

        adminJpa.save(admins);

        return ResponseEntity.ok("Profile updated successfully");
    }






}


