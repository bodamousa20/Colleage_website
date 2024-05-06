package college.College.Model;

import college.College.Reprositry.StudentJpa;

public class GradeClass {
    private Integer id;
    private float gpa ;
    GradeClass(){}


    public GradeClass(Integer id, float gpa, StudentJpa studentJpa) {
        this.id = id;
        this.gpa = gpa;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public Integer getId() {
        return id;
    }

    public float getGpa() {
        return gpa;
    }
}
