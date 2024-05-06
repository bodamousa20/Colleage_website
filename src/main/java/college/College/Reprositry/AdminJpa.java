package college.College.Reprositry;

import college.College.Model.AdminClass;
import college.College.Model.StudentClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminJpa extends JpaRepository<AdminClass , Integer> {

    AdminClass findByEmail(String email);

}
