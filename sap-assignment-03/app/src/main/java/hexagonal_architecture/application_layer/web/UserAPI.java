package hexagonal_architecture.application_layer.web;

import hexagonal_architecture.domain_layer.model.User;
import hexagonal_architecture.domain_layer.service.DomainDataService;
import hexagonal_architecture.application_layer.service.exception.EScooterNotYetRegisteredException;
import hexagonal_architecture.application_layer.service.exception.ResourceIdAlreadyExistingException;
import hexagonal_architecture.application_layer.service.exception.UserNotYetRegisteredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class UserAPI {

    @Autowired
    private DomainDataService<User, String> userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok().body(this.userService.getAllResources());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        return ResponseEntity.ok().body(this.userService.getResourceById(id));
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(User user) throws ResourceIdAlreadyExistingException, UserNotYetRegisteredException, EScooterNotYetRegisteredException {
        return ResponseEntity.ok().body(this.userService.createResource(user));
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User user) {
        user.setId(id); // TODO delete
        return ResponseEntity.ok().body(this.userService.updateResource(id, user));
    }

    @DeleteMapping("/users/{id}")
    public HttpStatus deleteUser(@PathVariable String id) {
        this.userService.deleteResource(id);
        return HttpStatus.OK;
    }
}
