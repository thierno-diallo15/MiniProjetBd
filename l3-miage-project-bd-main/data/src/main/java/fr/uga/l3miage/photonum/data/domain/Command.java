package fr.uga.l3miage.photonum.data.domain;

import java.util.Date;
import java.util.List;

import org.hibernate.Internal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Command")
public class Command {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "date_command", nullable = false)
    private Date date;
    // todo the mapping
    @Column(name = "totalprice", nullable = false)
    private Double totalPrice;
    @Column(name = "deliveryAddress", nullable = false)
    private String deliveryAddress;

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "command")
    private List<Article> articles;

    public Command() {
    }

    public Command(Date date, Double totalPrice, String deliveryAddress, Client client, List<Article> articles) {
        this.date = date;
        this.totalPrice = totalPrice;
        this.deliveryAddress = deliveryAddress;
        this.client = client;
        this.articles = articles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    // todo generate getters and setters after mapping
}
