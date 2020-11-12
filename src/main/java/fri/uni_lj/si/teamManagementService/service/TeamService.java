package fri.uni_lj.si.teamManagementService.service;


import fri.uni_lj.si.teamManagementService.model.Team;
import fri.uni_lj.si.teamManagementService.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;


    public List<Team> getAllTeams() {
        List<Team> teams = teamRepository.findAll();

        return teams;
    }

    public Team getTeamById(Long id) {
        Optional<Team> team = teamRepository.findById(id);

        if(team.isPresent()){
            return team.get();
        }

        return null;
    }

    public Team addTeam(Team newTeam) {
        Team team = teamRepository.save(newTeam);
        return team;
    }

    public Team editTeam(Team newTeam, Long id) {
        Optional<Team> team = teamRepository.findById(id);

        if(team.isPresent()) {
            Team currentTeam = team.get();

            if(newTeam.getTeamName() != null) {
                currentTeam.setTeamName(newTeam.getTeamName());
            }

            return teamRepository.save(currentTeam);
        }

        return null;
    }

    public String deleteTeam(Long id) {
        Optional<Team> team = teamRepository.findById(id);

        if(team.isPresent()) {
            teamRepository.deleteById(id);
            return "Team " + id + " deleted.";
        }
        else {
            return "Team " + id + " not found";
        }
    }

}
