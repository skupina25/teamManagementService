package fri.uni_lj.si.teamManagementService.service;

import fri.uni_lj.si.teamManagementService.model.Team;
import fri.uni_lj.si.teamManagementService.model.User;
import fri.uni_lj.si.teamManagementService.repository.TeamRepository;
import fri.uni_lj.si.teamManagementService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TeamRepository teamRepository;


    public List<User> getAllUsersForTeam(Long teamId) {
        Optional<Team> team = teamRepository.findById(teamId);

        if(team.isPresent()) {
            return team.get().getUsers();
        }
        return null;
    }

    public User getUserById(Long taskId) {
        Optional<User> user = userRepository.findById(taskId);

        if(user.isPresent()){
            return user.get();
        }

        return null;
    }

    public Team addUserToTeam(User newUser, Long teamId) {
        Optional<Team> team = teamRepository.findById(teamId);

        if(team.isPresent()) {


            Team teamObj = team.get();
            newUser.setTeam(teamObj);
            List<User> teamUsersList = teamObj.getUsers();
            teamUsersList.add(newUser);
            teamObj.setUsers(teamUsersList);


            return teamRepository.save(teamObj);

        }
        return null;

    }

    public User editUser(User newUser, Long userId) {
        Optional<User> user = userRepository.findById(userId);

        if(user.isPresent()) {
            User currentUser = user.get();

            if(newUser.getUsername() != null) {
                currentUser.setUsername(newUser.getUsername());
            }

            if(newUser.getFirstName() != null) {
                currentUser.setFirstName(newUser.getFirstName());
            }

            if(newUser.getLastName() != null) {
                currentUser.setLastName(newUser.getLastName());
            }

            if(newUser.getEmail() != null) {
                currentUser.setEmail(newUser.getEmail());
            }

            if(newUser.getPassword() != null) {
                currentUser.setPassword(newUser.getPassword());
            }

            return userRepository.save(currentUser);
        }

        return null;
    }

    public String deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()) {
            User userObj = user.get();
            Team parentTeam = userObj.getTeam();
            parentTeam.getUsers().remove(userObj);
            teamRepository.save(parentTeam);

            return "User " + id + " deleted.";
        }
        else {
            return "User " + id + " not found";
        }
    }




}
