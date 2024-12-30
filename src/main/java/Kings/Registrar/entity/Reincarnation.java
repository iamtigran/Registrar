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

    private String reincarnatedDate;

    private String attributes;

    @ManyToOne
    @JoinColumn(name = "originalPerson_id", nullable = false)
    private OriginalPerson originalPerson;

    public Reincarnation() {
    }

    public Reincarnation(String name, String reincarnatedDate, String attributes, String lastName) {
        this.name = name;
        this.reincarnatedDate = reincarnatedDate;
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

    public String getReincarnatedDate() {
        return reincarnatedDate;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setOriginalPerson(OriginalPerson originalPerson) {
        this.originalPerson = originalPerson;
    }

    @Override
    public String toString() {
        return "Reincarnation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", reincarnatedDate='" + reincarnatedDate + '\'' +
                ", attributes='" + attributes + '\'' +
                '}';
    }
}