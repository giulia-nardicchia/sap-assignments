package hexagonal_architecture.application_layer.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// TODO delete
@RequestMapping("/api")
@RestController
public class WebUIAPI {

    @GetMapping("/")
    public ResponseEntity<List<String>> getURIs() {
        return ResponseEntity.ok().body(List.of(
                "http://localhost/8080/api/users",
                "http://localhost/8080/api/escooters",
                "http://localhost/8080/api/rides"
        ));
    }
}
