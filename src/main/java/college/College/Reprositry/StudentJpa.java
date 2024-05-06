package college.College.Reprositry;

import college.College.Model.StudentClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentJpa extends JpaRepository<StudentClass,Integer> {
    StudentClass findByEmail(String email);

}
