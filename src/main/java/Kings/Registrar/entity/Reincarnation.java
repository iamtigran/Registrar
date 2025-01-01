package Kings.Registrar.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "reincarnation")
public class Reincarnation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String lastName;

    private String branch;

    private String reincarnationFamily;

    private String reincarnationGeneration;

    private String attributes;

    @ManyToOne
    @JoinColumn(name = "originalPerson_id", nullable = false)
    private OriginalPerson originalPerson;

    public Reincarnation() {
    }

    public Reincarnation(
            String name,
            String reincarnationGeneration,
            String attributes, String lastName, String reincarnationFamily) {
        this.name = name;
        this.reincarnationGeneration = reincarnationGeneration;
        this.reincarnationFamily=reincarnationGeneration;
        this.lastName = lastName;
        this.attributes = attributes;
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

    public String getReincarnationGeneration() {
        return reincarnationGeneration;
    }

    public String getAttributes() {
        return attributes;
    }

    public String getReincarnationFamily() {
        return reincarnationFamily;
    }

    public String getBranch() {
        return branch;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setReincarnationGeneration(String reincarnationGeneration) {
        this.reincarnationGeneration = reincarnationGeneration;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public void setOriginalPerson(OriginalPerson originalPerson) {
        this.originalPerson = originalPerson;
    }

    public void setReincarnationFamily(String reincarnationFamily) {
        this.reincarnationFamily = reincarnationFamily;
    }

    @Override
    public String toString() {
        return "Reincarnation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", reincarnationGeneration='" + reincarnationGeneration + '\'' +
                ", branch='" + branch + '\'' +
                ", reincarnationFamily='" + reincarnationFamily + '\'' +
                ", attributes='" + attributes + '\'' +
                '}';
    }
}