package hexagonal_architecture.infrastructure_layer.in.web;

import hexagonal_architecture.domain_layer.model.Ride;
import hexagonal_architecture.domain_layer.model.User;
import hexagonal_architecture.domain_layer.model.EScooter;
import hexagonal_architecture.domain_layer.service.RideMonitoringService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/views")
public class WebUIAdapter {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/user")
    public String userRegistration(Model model) {
        User user = new User("wwhitman", "Walt", "Withman");
        model.addAttribute("user", user);
        return "user-registration";
    }

    @GetMapping("/escooter")
    public String eScooterRegistration(Model model) {
        EScooter escooter = new EScooter();
        model.addAttribute("escooter", escooter);
        return "escooter-registration";
    }

    @GetMapping("/ride-registration")
    public String rideRegistration(Model model) {
        Ride ride = new Ride();
        model.addAttribute("ride", ride);
        return "ride-registration";
    }
}