package fr.uga.l3miage.photonum.data.domain;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import static jakarta.persistence.FetchType.EAGER;


@Entity
public class Address {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String description;

    @ManyToMany(mappedBy = "addresses",fetch = EAGER)
    private Set<Client> clients;

    
    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }
    
    
    

    
}
