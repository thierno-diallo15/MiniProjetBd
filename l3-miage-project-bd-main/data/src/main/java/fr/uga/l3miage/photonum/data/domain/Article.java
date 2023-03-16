package fr.uga.l3miage.photonum.data.domain;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    @Column(name = "quantity", nullable = false)
    private int quantity;
    @Column(name = "price", nullable = false)
    private Double price;
    // Todo generate getters and setters afters the mapping
    @ManyToOne
    private Command command;
    @OneToOne
    private Impression impression;

    public Article() {
    }

    public Article(int quantity, Double price, Command command, Impression impression) {
        this.quantity = quantity;
        this.price = price;
        this.command = command;
        this.impression = impression;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public Impression getImpression() {
        return impression;
    }

    public void setImpression(Impression impression) {
        this.impression = impression;
    }

}
