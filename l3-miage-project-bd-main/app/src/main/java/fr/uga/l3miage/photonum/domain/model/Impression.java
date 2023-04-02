package fr.uga.l3miage.photonum.domain.model;

import java.util.Objects;

import jakarta.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Impression {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // remplacer car String si besoin
    
    @Column(name = "price", nullable = false)
    private Double price;

    @ManyToOne
    private Client client;

    @OneToOne(optional = true)
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
    public boolean equals(Object o){
        if(o == null) return false;
        if(!(o instanceof Impression impression)) return false;
        return Objects.equals(price , impression.price)
            && Objects.equals(client, impression.client)
            && Objects.equals(article, impression.article);
    }
    public int hashCode(){
        return Objects.hash(price, client, article);
    }

}
