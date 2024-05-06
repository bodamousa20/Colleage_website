package college.College.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Student")


public class StudentClass {
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
    @Column(name = "level")
    private int level;
    @Column(name = "accumulator_gpa")
    private float accumulator_gpa;
    @Column(name = "department")
    private String department;
    @ManyToMany
    @JoinTable(
            name = "StudentCourse",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )

    private List<CourceClass> enrolledCourses;
        public StudentClass(){};

    public StudentClass(Integer id, String name, Integer age, String ssn, String email, String password, String gender, int level, float accumulator_gpa, String department, List<CourceClass> enrolledCourses) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.ssn = ssn;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.level = level;
        this.accumulator_gpa = accumulator_gpa;
        this.department = department;
        this.enrolledCourses = enrolledCourses;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<CourceClass> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<CourceClass> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
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

        public void setLevel(int level) {
            this.level = level;
        }

        public void setAccumulator_gpa(float accumulator_gpa) {
            this.accumulator_gpa = accumulator_gpa;
        }

        public void setDepartment(String department) {
            this.department = department;
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

        public int getLevel() {
            return level;
        }

        public float getAccumulator_gpa() {
            return accumulator_gpa;
        }

        public String getDepartment() {
            return department;
        }
    }


