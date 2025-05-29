package hexagonal_architecture.infrastructure_layer.in.web;

import hexagonal_architecture.domain_layer.service.RideMonitoringService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class DashboardWebAdapter {

    private final RideMonitoringService monitoringService;

    public DashboardWebAdapter(RideMonitoringService monitoringService) {
        this.monitoringService = monitoringService;
    }

    @GetMapping("/ride")
    public String rideDashboard(Model model) {
        int total = monitoringService.countTotalRides();
        int ongoing = monitoringService.countOngoingRides();
        int ended = monitoringService.countEndedRides();

        model.addAttribute("totalRides", total);
        model.addAttribute("ongoingRides", ongoing);
        model.addAttribute("endedRides", ended);

        double ongoingPct = total == 0 ? 0 : (ongoing * 100.0) / total;
        double endedPct = total == 0 ? 0 : (ended * 100.0) / total;

        model.addAttribute("ongoingPct", ongoingPct);
        model.addAttribute("endedPct", endedPct);
        return "ride-dashboard";
    }
}

