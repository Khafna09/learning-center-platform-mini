package pe.edu.upc.center.platform.profiles.interfaces.rest;

import org.springframework.web.bind.annotation.*;
import pe.edu.upc.center.platform.profiles.domain.model.Entities.Objective;
import pe.edu.upc.center.platform.profiles.infrastructure.persistence.jpa.repositories.ObjectiveRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/objectives")
public class ObjectiveController {
    private final ObjectiveRepository repository;

    public ObjectiveController(ObjectiveRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Objective> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Objective create(@RequestBody Objective obj) {
        return repository.save(obj);
    }
}
