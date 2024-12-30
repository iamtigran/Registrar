package Kings.Registrar.service;

import Kings.Registrar.entity.OriginalPerson;
import Kings.Registrar.entity.Reincarnation;
import Kings.Registrar.repository.OriginalPersonRepository;
import Kings.Registrar.repository.ReincarnationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OriginalPersonService {

    @Autowired
    private OriginalPersonRepository originalPersonRepository;

    @Autowired
    private ReincarnationRepository reincarnationRepository;

    // Create an OriginalPerson
    public OriginalPerson createOriginalPerson(OriginalPerson person) {
        return originalPersonRepository.save(person);
    }

    public OriginalPerson updateOriginalPerson(Integer id, OriginalPerson updatedPerson) {
        // Find the original person by ID
        return originalPersonRepository.findById(id)
                .map(person -> {
            // Update fields
            person.setName(updatedPerson.getName());
            person.setLastName(updatedPerson.getLastName());
            person.setBirthDate(updatedPerson.getBirthDate());
            person.setAttributes(updatedPerson.getAttributes());
            // Save the updated person
            return originalPersonRepository.save(person);
        }).orElseThrow(() -> new RuntimeException("OriginalPerson not found with ID: " + id));
    }

    // Get all OriginalPersons
    public List<OriginalPerson> getAllOriginalPersons() {
        return originalPersonRepository.findAll();
    }

    // Add a reincarnation to a specific OriginalPerson
    public Reincarnation addReincarnation(int originalPersonId, Reincarnation reincarnation) {
        OriginalPerson originalPerson = originalPersonRepository.findById(originalPersonId)
                .orElseThrow(() -> new RuntimeException("OriginalPerson not found with ID: " + originalPersonId));
        reincarnation.setOriginalPerson(originalPerson);
        return reincarnationRepository.save(reincarnation);
    }

    // Get all reincarnations of a specific OriginalPerson
    public List<Reincarnation> getReincarnationsByOriginalPerson(int originalPersonId) {
        return reincarnationRepository.findByOriginalPersonId(originalPersonId);
    }
}
