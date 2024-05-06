package college.College.Model;

public class DoctorPeofileUpdateRequest {

    private String name;

    private int age;



    private String password;

    public DoctorPeofileUpdateRequest(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }
}
