package college.College.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class DoctorClass {
    @Id
    @Column(name = "id")
    private  Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private Integer age;
    @Column(name = "ssn")
    private String ssn;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "gender")
    private String gender;
    @Column(name = "salary")
    private double salary;




    @ManyToMany
    @JoinTable(
            name = "doctor_course",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<CourceClass> courses = new ArrayList<>();

    public DoctorClass(){};
    public DoctorClass(Integer id, String name, Integer age, String ssn, String email, String password, String gender, double salary, List<CourceClass> courses) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.ssn = ssn;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.salary = salary;
        this.courses = courses;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<CourceClass> getCourses() {
        return courses;
    }

    public void setCourses(List<CourceClass> courses) {
        this.courses = courses;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getSsn() {
        return ssn;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }
}
