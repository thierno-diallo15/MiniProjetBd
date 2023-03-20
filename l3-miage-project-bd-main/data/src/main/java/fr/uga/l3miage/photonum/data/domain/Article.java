package fr.uga.l3miage.photonum.data.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
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
    // Todo the mapping
    @Enumerated(EnumType.ORDINAL)
    private Catalog formatQuality;

    @Column(name = "quantity", nullable = false)
    private int quantity;
    
    @Column(name = "price", nullable = false)
    private Double price;
    // Todo generate getters and setters afters the mapping
    
    @ManyToOne
    private Order order;
    
    @OneToOne
    private Impression impression;

    public Article() {
    }

    public Article(Catalog formatQuality, int quantity, Double price, Order order, Impression impression) {
        this.formatQuality = formatQuality;
        this.quantity = quantity;
        this.price = price;
        this.order = order;
        this.impression = impression;
    }

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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Impression getImpression() {
        return impression;
    }

    public void setImpression(Impression impression) {
        this.impression = impression;
    }

    

}
