package college.College.Reprositry;

import college.College.Model.DoctorClass;
import college.College.Model.StudentClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorJpa extends JpaRepository<DoctorClass,Integer> {
    DoctorClass findByEmail(String email);

}
