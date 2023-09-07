package tacos.security;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tacos.User;
import tacos.data.UserRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/login")
public class LoginController {

    private UserRepository userRepo;

    public LoginController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping(consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public User login(@RequestBody User form) {
      return userRepo.save(userRepo.findByUsername(form.getUsername()));

    }

}
