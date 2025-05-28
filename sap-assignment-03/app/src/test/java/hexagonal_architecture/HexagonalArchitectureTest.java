package hexagonal_architecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.library.Architectures.onionArchitecture;

class HexagonalArchitectureTest {

    @Test
    public void hexagonalArchitectureRule() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("hexagonal_architecture");

        ArchRule ruleLayered = onionArchitecture()
                .domainModels("..domain_layer.model..")
                .domainServices("..domain_layer.service..")
                .applicationServices("..application_layer..")
                //.adapter("cli", "..adapter.cli..")
                .adapter("persistence", "..infrastructure_layer.persistence..")
                .adapter("rest", "..infrastructure_layer.rest..");
        // TODO infrastructure_layer

        ruleLayered.check(importedClasses);

        // port -->
        // DataSourcePort --> persistenza specifica
        // RideDashboardPort (notifyNewRide, notifyRideEnded)
        // le porte devono stare nel package della business logic / use cases

        // adapter -->
        // FileSystemAdapter implements DataSourcePort
        // WebBasedAdapter (vertx) implements RideDashboardPort

        //Infrastructure layer (data source - DB, UI)

        // Application API (uguale al ServiceLayer dell'esercizio precedente)
        // azioni che sono sequenzaiali (sincrono)
        // ad esempio: startNewRide restituisce l'id della corsa...
        // presupponiamo che non ci sia concorrenza
    }

}