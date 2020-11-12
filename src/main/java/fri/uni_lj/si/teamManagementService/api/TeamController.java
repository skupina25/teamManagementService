package fri.uni_lj.si.teamManagementService.api;

import fri.uni_lj.si.teamManagementService.model.Team;
import fri.uni_lj.si.teamManagementService.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {


    @Autowired
    private TeamService teamService;

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello world";
    }

    @PostMapping("/team")
    public Team addTeam(@RequestBody Team newTeam) {
        return teamService.addTeam(newTeam);
    }

    @GetMapping("/team/{teamId}")
    public Team getTeamById(@PathVariable Long teamId ) {
        return teamService.getTeamById(teamId);
    }

    @GetMapping("/team")
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @PostMapping("/team/{teamId}")
    public Team editTeam(@RequestBody Team newTeam, @PathVariable Long teamId) {
        return teamService.editTeam(newTeam, teamId);
    }

    @DeleteMapping("/team/{teamId}")
    public String deleteTeam(@PathVariable Long teamId ) {
        return teamService.deleteTeam(teamId);
    }

}
