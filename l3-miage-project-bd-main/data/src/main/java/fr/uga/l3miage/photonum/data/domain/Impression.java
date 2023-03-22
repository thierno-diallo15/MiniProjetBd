package fr.uga.l3miage.photonum.data.domain;

import jakarta.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Impression {
    @Id
    @GeneratedValue
    private Long id; // remplacer car String si besoin
    
    @Column(name = "price", nullable = false)
    private Double price;

    @ManyToOne
    private Client person;

    @OneToOne
    private Article article;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Client getPerson() {
        return person;
    }

    public void setPerson(Client person) {
        this.person = person;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

}
