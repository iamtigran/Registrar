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

    private String birthDate;

    private String attributes;

    @OneToMany(mappedBy = "originalPerson", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Reincarnation> reincarnations = new ArrayList<>();

    public OriginalPerson() {
    }

    public OriginalPerson(String name, String birthDate, String attributes,String lastName) {
        this.name = name;
        this.birthDate = birthDate;
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

    public String getBirthDate() {
        return birthDate;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
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
                ", birthDate='" + birthDate + '\'' +
                ", attributes='" + attributes + '\'' +
                ", reincarnations=" + reincarnations.size() +
                '}';
    }
}
