package college.College.Model;

import jakarta.persistence.*;

@Entity
public class AdminClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;

    @Column(name = "ssn")
    private String ssn;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    public  AdminClass (){} ;

    public AdminClass(Integer id, String name, String ssn, String email, String password) {
        this.id = 0;
        this.name = name;
        this.ssn = ssn;
        this.email = email;
        this.password = password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
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
}