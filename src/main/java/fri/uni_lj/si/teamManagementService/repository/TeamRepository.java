package fri.uni_lj.si.teamManagementService.repository;

import fri.uni_lj.si.teamManagementService.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
