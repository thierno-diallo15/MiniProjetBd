package fr.uga.l3miage.photonum.data.domain;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class Address {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Client client;

    @Column(nullable = false)
    private String description;

    public Address(Long id, Client client, String description) {
        this.id = id;
        this.client = client;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
