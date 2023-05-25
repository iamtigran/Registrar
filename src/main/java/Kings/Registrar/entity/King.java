package Kings.Registrar.entity;


import jakarta.persistence.*;

@Entity
    @Table(name = "kings")
    public class King {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;

        private Integer numb;

        // Constructors, getters, and setters

    public King(Long id, String name, Integer numb) {
        this.id = id;
        this.name = name;
        this.numb =  numb;
    }

    public King(){

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

    public int getNumb() {
        return numb;
    }

    public void setNumb(Integer numb) {
        this.numb = numb;
    }
}

