package Kings.Registrar.controller;

import Kings.Registrar.entity.OriginalPerson;
import Kings.Registrar.entity.Reincarnation;
import Kings.Registrar.service.OriginalPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/persons")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class OriginalPersonController {

    @Autowired
    private OriginalPersonService originalPersonService;

    // Create an OriginalPerson
    @PostMapping
    public OriginalPerson createOriginalPerson(@RequestBody OriginalPerson person) {
        return originalPersonService.createOriginalPerson(person);
    }

    @PutMapping("/update/{id}")
    public OriginalPerson updateOriginalPerson(
            @PathVariable Integer id,
            @RequestBody OriginalPerson updatedPerson) {
        return originalPersonService.updateOriginalPerson(id, updatedPerson);
    }

    // Get all OriginalPersons
    @GetMapping
    public List<OriginalPerson> getAllOriginalPersons() {
        return originalPersonService.getAllOriginalPersons();
    }


    @GetMapping("/{id}")
    public OriginalPerson getOriginalPerson(
            @PathVariable Integer id ) {
        return originalPersonService.getOriginalPerson(id);
    }

    // Add a reincarnation to a specific OriginalPerson
    @PostMapping("/{id}/reincarnations")
    public Reincarnation addReincarnation(
            @PathVariable int id,
            @RequestBody Reincarnation reincarnation
    ) {
        return originalPersonService.addReincarnation(id, reincarnation);
    }

    // Get all reincarnations of a specific OriginalPerson
    @GetMapping("/{id}/reincarnations")
    public List<Reincarnation> getReincarnationsByOriginalPerson(@PathVariable int id) {
        return originalPersonService.getReincarnationsByOriginalPerson(id);
    }

    @GetMapping("/reincarnations")
    public List<Reincarnation> getAllReincarnations(){
      return originalPersonService.getAllReincarnations();
    }

    @PutMapping("/{id}/reincarnation")
    public Reincarnation updateReincarnation(
            @PathVariable Integer id,
            @RequestBody Reincarnation updatedReincarnation) {
        return originalPersonService.updateReincarnation(id, updatedReincarnation);
    }

    @DeleteMapping("/reincarnation/{id}")
    public void deleteReincarnation(
            @PathVariable Integer id) {
        originalPersonService.deleteReincarnation(id);
    }
}
