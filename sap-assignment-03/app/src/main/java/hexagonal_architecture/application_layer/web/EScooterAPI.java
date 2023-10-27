package hexagonal_architecture.application_layer.web;

import hexagonal_architecture.domain_layer.model.EScooter;
import hexagonal_architecture.domain_layer.service.DataService;
import hexagonal_architecture.application_layer.service.exception.NotYetRegisteredException;
import hexagonal_architecture.application_layer.service.exception.IdAlreadyExistingException;
import hexagonal_architecture.application_layer.service.exception.UserNotYetRegisteredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class EScooterAPI {

    @Autowired
    private DataService<EScooter, String> escooterService;

    @GetMapping("/escooters")
    public ResponseEntity<List<EScooter>> getAllEScooters() {
        return ResponseEntity.ok().body(this.escooterService.getAllResources());
    }

    @GetMapping("/escooters/{id}")
    public ResponseEntity<EScooter> getEScooterById(@PathVariable String id) {
        return ResponseEntity.ok().body(this.escooterService.getResourceById(id));
    }

    @PostMapping("/escooters")
    public ResponseEntity<EScooter> createEScooter(EScooter escooter) throws IdAlreadyExistingException, UserNotYetRegisteredException, NotYetRegisteredException {
        return ResponseEntity.ok().body(this.escooterService.createResource(escooter));
    }

    @PutMapping("/escooters/{id}")
    public ResponseEntity<EScooter> updateEScooter(@PathVariable String id, @RequestBody EScooter escooter) {
        return ResponseEntity.ok().body(this.escooterService.updateResource(id, escooter));
    }

    @DeleteMapping("/escooters/{id}")
    public HttpStatus deleteEScooter(@PathVariable String id) {
        this.escooterService.deleteResource(id);
        return HttpStatus.OK;
    }
}
