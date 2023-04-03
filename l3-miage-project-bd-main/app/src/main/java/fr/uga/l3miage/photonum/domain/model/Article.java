package fr.uga.l3miage.photonum.domain.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotBlank( message = " formatQuality is requierd")
    private Catalog formatQuality;

    @Column(nullable = false)
    @NotBlank( message = " quantity ")
    private int quantity;
    
    @Column(nullable = false)
    @NotBlank( message = " price is requierd ")
    private Double price;
    
    @ManyToOne
    private Commande commande;


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

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
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
            && Objects.equals(commande, article.commande);
    }

    @Override
    public int hashCode() {
        return Objects.hash(formatQuality,quantity,price,commande);
    }


}


    


