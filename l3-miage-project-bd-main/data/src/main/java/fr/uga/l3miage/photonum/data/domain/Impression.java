package fr.uga.l3miage.photonum.data.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type_impression", discriminatorType = DiscriminatorType.STRING)
@Table(name = "Impression")
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

    @Enumerated
    private Catalog formatQuality;

    public Impression(Double price, Client person, Article article, Catalog formatQuality) {
        this.price = price;
        this.person = person;
        this.article = article;
        this.formatQuality = formatQuality;
    }

    public Impression(){
        
    }

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

    public Catalog getFormatQuality() {
        return formatQuality;
    }

    public void setFormatQuality(Catalog formatQuality) {
        this.formatQuality = formatQuality;
    }

    // todo Generate getters and the setters after mapping
}
