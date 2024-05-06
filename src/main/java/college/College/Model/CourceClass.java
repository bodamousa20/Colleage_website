package college.College.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Course")
public class CourceClass {

    @Id
    private Integer id;
    private String name;

    // Relation of student and assigned Course to him
    @ManyToMany(mappedBy = "enrolledCourses")
    private List<StudentClass> enrolledStudents;




    // Relation of Doctor and the  Course will he teach
    @ManyToMany(mappedBy = "courses")
    private List<DoctorClass> doctors = new ArrayList<>();
    private String department; // Add department field

    // Other mappings and methods...

    // Getter and setter for department


    // Constructor and other methods...






    CourceClass(){}

    public CourceClass(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
