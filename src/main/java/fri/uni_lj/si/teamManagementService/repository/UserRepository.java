package fri.uni_lj.si.teamManagementService.repository;

import fri.uni_lj.si.teamManagementService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
