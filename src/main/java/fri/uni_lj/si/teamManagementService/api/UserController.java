package fri.uni_lj.si.teamManagementService.api;

import fri.uni_lj.si.teamManagementService.model.Team;
import fri.uni_lj.si.teamManagementService.model.User;
import fri.uni_lj.si.teamManagementService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/team/{teamId}/user")
    public List<User> getAllUsersForTeam(@PathVariable Long teamId) {
        return userService.getAllUsersForTeam(teamId);
    }

    @GetMapping("/user/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("/team/{teamId}/user")
    public Team addUserToTeam(@RequestBody User newUser, @PathVariable Long teamId) {
        return userService.addUserToTeam(newUser, teamId);
    }

    @PostMapping("/user/{userId}")
    public User editUser(@RequestBody User newUser, @PathVariable Long userId) {
        return userService.editUser(newUser, userId);
    }

    @DeleteMapping("/user/{userId}")
    public String deleteUser(@PathVariable Long userId ) {
        return userService.deleteUser(userId);
    }

}
