package college.College.Reprositry;

import college.College.Model.CourceClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourceJpa extends JpaRepository<CourceClass,Integer> {
}
