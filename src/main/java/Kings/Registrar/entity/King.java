package Kings.Registrar.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "kings")
public class King {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String numb;

    // Constructors, getters, and setters

    public King(Long id, String name, String numb) {
        this.id = id;
        this.name = name;
        this.numb = numb;
    }

    public King() {


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumb() {
        return numb;
    }

    public void setNumb(String numb) {
        this.numb = numb;
    }
}

