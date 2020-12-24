package fri.uni_lj.si.teamManagementService.api;

import fri.uni_lj.si.teamManagementService.model.Team;
import fri.uni_lj.si.teamManagementService.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping("api/v1")
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


    // get all boards for team
    @GetMapping("/team/{teamId}/boards")
    private List<Long> getAllBoardsForTeam(@PathVariable Long teamId) {
        Team t = teamService.getTeamById(teamId);
        return t.getBoards();
    }

    // add board to team
    @PostMapping("/team/{teamId}/boards")
    private Team addBoardToTeam(@PathVariable Long teamId, @RequestBody Long boardId) {

        Team t = teamService.getTeamById(teamId);
        List<Long> teamBoards = t.getBoards();
        teamBoards.add(boardId);
        t = teamService.editTeam(t, teamId);
        return t;
    }

    @PostMapping("/team/{teamId}/boards/{boardId}")
    private Team editBoardId(@PathVariable Long teamId, @PathVariable Long boardId, @RequestBody Long newBoardId) {

        Team t = teamService.getTeamById(teamId);
        List<Long> teamBoards = t.getBoards();
        teamBoards.remove(boardId);
        teamBoards.add(newBoardId);
        t = teamService.editTeam(t, teamId);
        return t;
    }

    // delete boards from team
    @DeleteMapping("/team/{teamId}/boards/{boardId}")
    private Team deleteBoardId(@PathVariable Long teamId, @PathVariable Long boardId) {

        Team t = teamService.getTeamById(teamId);
        List<Long> teamBoards = t.getBoards();
        teamBoards.remove(boardId);
        t = teamService.editTeam(t, teamId);
        return t;
    }


}
