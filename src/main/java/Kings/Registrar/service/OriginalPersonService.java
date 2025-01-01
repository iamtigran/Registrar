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
            person.setOriginalGeneration(updatedPerson.getOriginalGeneration());
            person.setBranch(updatedPerson.getBranch());
            person.setOriginalFamily(updatedPerson.getOriginalFamily());
            person.setAttributes(updatedPerson.getAttributes());
            // Save the updated person
            return originalPersonRepository.save(person);
        }).orElseThrow(() -> new RuntimeException("OriginalPerson not found with ID: " + id));
    }

    // Get all OriginalPersons
    public List<OriginalPerson> getAllOriginalPersons() {
        return originalPersonRepository.findAll();
    }

    public OriginalPerson getOriginalPerson(Integer id){
        return  originalPersonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OriginalPerson not found with id: " + id));
    }

    public List<Reincarnation> getAllReincarnations() {
        return reincarnationRepository.findAll();
    }


    public Reincarnation updateReincarnation(Integer id, Reincarnation updatedReincarnation) {
        // Find the original person by ID
        return reincarnationRepository.findById(id)
                .map(reincarnatedPerson -> {
                    // Update fields
                    reincarnatedPerson.setName(updatedReincarnation.getName());
                    reincarnatedPerson.setLastName(updatedReincarnation.getLastName());
                    reincarnatedPerson.setReincarnationGeneration(updatedReincarnation.getReincarnationGeneration());
                    reincarnatedPerson.setReincarnationFamily(updatedReincarnation.getReincarnationFamily());
                    reincarnatedPerson.setBranch(updatedReincarnation.getBranch());
                    reincarnatedPerson.setAttributes(updatedReincarnation.getAttributes());
                    // Save the updated person
                    return reincarnationRepository.save(reincarnatedPerson);
                }).orElseThrow(() -> new RuntimeException("Reincarnation not found with ID: " + id));
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

    public void deleteReincarnation(Integer id) {
     reincarnationRepository.deleteById(id);
    }
}
