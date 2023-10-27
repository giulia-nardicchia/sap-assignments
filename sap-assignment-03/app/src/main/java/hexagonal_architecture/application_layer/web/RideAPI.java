package hexagonal_architecture.application_layer.web;

import hexagonal_architecture.domain_layer.model.Ride;
import hexagonal_architecture.domain_layer.service.DataService;
import hexagonal_architecture.application_layer.service.exception.NotYetRegisteredException;
import hexagonal_architecture.application_layer.service.exception.IdAlreadyExistingException;
import hexagonal_architecture.application_layer.service.exception.UserNotYetRegisteredException;
import hexagonal_architecture.domain_layer.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class RideAPI {

    @Autowired
    private DataService<Ride, String> rideService;

    @GetMapping("/rides")
    public ResponseEntity<List<Ride>> getAllRide() {
        return ResponseEntity.ok().body(this.rideService.getAllResources());
    }

    @GetMapping("/rides/{id}")
    public ResponseEntity<Ride> getRideById(@PathVariable String id) {
        return ResponseEntity.ok().body(this.rideService.getResourceById(id));
    }

    @PostMapping("/rides")
    public ResponseEntity<Ride> createRide(Ride ride) throws IdAlreadyExistingException, UserNotYetRegisteredException, NotYetRegisteredException {
        return ResponseEntity.ok().body(this.rideService.createResource(ride));
    }

    @PutMapping("/rides/{id}")
    public ResponseEntity<Ride> updateRide(@PathVariable String id, @RequestBody Ride ride) {
        ride.setId(id); // TODO delete
        return ResponseEntity.ok().body(this.rideService.updateResource(id, ride));
    }

    @DeleteMapping("/rides/{id}")
    public HttpStatus deleteRide(@PathVariable String id) {
        this.rideService.deleteResource(id);
        return HttpStatus.OK;
    }

    @GetMapping("/rides/{id}/end")
    public ResponseEntity<Ride> endRide(@PathVariable String id) {
        return ResponseEntity.ok().body(((RideService) this.rideService).endRide(id));
    }
}
