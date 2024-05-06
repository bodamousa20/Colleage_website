package college.College.Model;

public class AdminUpdate {
    private String password ;

    public AdminUpdate(String name, String password) {
        this.password = password;
    }


    public void setPassword(String password) {
        this.password = password;
    }



    public String getPassword() {
        return password;
    }
}
