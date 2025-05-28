package hexagonal_architecture.domain_layer.service;

import hexagonal_architecture.domain_layer.model.EScooter;

import java.util.List;

//TODO delete
public interface EScooterService {
    EScooter createEScooter(EScooter escooter);

    EScooter updateEScooter(EScooter escooter);

    List<EScooter> getAllEScooters();

    EScooter getEScooterById(long id);

    void deleteEScooter(long id);
}
