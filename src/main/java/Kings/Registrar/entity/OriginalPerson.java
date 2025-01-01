package Kings.Registrar.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "originalperson")
public class OriginalPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String lastName;

    private String originalGeneration;

    private String branch;

    private String originalFamily;

    private String attributes;

    @OneToMany(mappedBy = "originalPerson", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Reincarnation> reincarnations = new ArrayList<>();

    public OriginalPerson() {
    }

    public OriginalPerson(String name, String originalGeneration, String attributes,String lastName, String branch) {
        this.name = name;
        this.originalGeneration = originalGeneration;
        this.branch=branch;
        this.attributes = attributes;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getOriginalGeneration() {
        return originalGeneration;
    }

    public String getAttributes() {
        return attributes;
    }

    public String getBranch(){return branch;}

    public String getOriginalFamily() {
        return originalFamily;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setOriginalGeneration(String originalGeneration) {
        this.originalGeneration = originalGeneration;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setOriginalFamily(String originalFamily) {
        this.originalFamily = originalFamily;
    }

    public List<Reincarnation> getReincarnations() {
        return reincarnations;
    }

    public void addReincarnation(Reincarnation reincarnation) {
        this.reincarnations.add(reincarnation);
        reincarnation.setOriginalPerson(this);
    }

    @Override
    public String toString() {
        return "OriginalPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastName + '\'' +
                ", birthDate='" + originalGeneration + '\'' +
                ", attributes='" + attributes + '\'' +
                ", branch='" + branch + '\'' +
                ", originalFamily='" + originalFamily + '\'' +
                ", reincarnations=" + reincarnations.size() +
                '}';
    }
}
