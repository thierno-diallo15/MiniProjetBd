package fr.uga.l3miage.photonum.data.domain;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Commande {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "order_date", nullable = false)
    private Date date;
    @Column(name = "total_price", nullable = false)
    private Double totalPrice;

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "commande")
    private List<Article> articles;
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

    public boolean equals(Object o){
        if(o == null) return false;
        if(!(o instanceof Commande commande)) return false;
        return Objects.equals(date, commande.date)
            && Objects.equals(totalPrice, commande.totalPrice)
            && Objects.equals(articles, commande.articles)
            && Objects.equals(client, commande.client);
    }
    public int hashCode(){
        return Objects.hash(date, totalPrice, articles, client);
    }

}
