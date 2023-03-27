package fr.uga.l3miage.photonum.data.domain;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Article")
public class Article {

    @Id
    @GeneratedValue
    private Long id;
    
    @Enumerated
    @Column(name = "formatQuality", nullable = false)
    private Catalog formatQuality;

    @Column(name = "quantity", nullable = false)
    private int quantity;
    
    @Column(name = "price", nullable = false)
    private Double price;
    
    @ManyToOne
    private Commande commande;
    
    @OneToOne
    private Impression impression;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Catalog getFormatQuality() {
        return formatQuality;
    }

    public void setFormatQuality(Catalog formatQuality) {
        this.formatQuality = formatQuality;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Article article))
            return false;
        return  formatQuality == article.formatQuality
            && Objects.equals(quantity, article.quantity)
            && Objects.equals(price, article.price)
            && Objects.equals(commande, article.commande)
            && Objects.equals(impression, article.impression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(formatQuality,quantity,price,commande,impression);
    }



}


    


