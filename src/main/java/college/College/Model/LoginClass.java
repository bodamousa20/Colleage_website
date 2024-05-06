package college.College.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginClass {
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String Email ;

    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password ;

    public LoginClass(String Email, String password) {
        this.Email = Email;
        this.password = password;
    }

    public void setUsername(String email) {
        this.Email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return Email;
    }

    public String getPassword() {
        return password;
    }
}
