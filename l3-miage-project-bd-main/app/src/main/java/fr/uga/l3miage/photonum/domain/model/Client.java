package fr.uga.l3miage.photonum.domain.model;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;


@Entity
public class Client {
    @Id
    @GeneratedValue
    private Long id;

    @Column( nullable = false)
    private String email;

    @Column( nullable = false)
    private String password;

    @Column( nullable = false)
    private String firstName;

    @Column
    private String lastName;

    @OneToMany(mappedBy = "client")
    private List<Commande> commandes;

    @OneToMany(mappedBy = "person")
    private List<Impression> impressions;

    // @OneToMany(cascade = {CascadeType.REMOVE},    //, CascadeType.PERSIST}, 
    //             mappedBy = "client", fetch = FetchType.EAGER)
    // private Set<Address> addresses;

    @OneToMany(mappedBy = "owner")
    private List<Image> photos;

    public Long getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean equals(Object o){
        if(this ==  o) return true;
        if(!(o instanceof Client client)) return false;
        return Objects.equals(email, client.email)
            && Objects.equals(password, client.password)
            && Objects.equals(firstName, client.firstName)
            && Objects.equals(lastName, client.lastName)
            && Objects.equals(commandes, client.commandes)
            && Objects.equals(photos, client.photos);
    }
    public int hashCode(){
        return Objects.hash(email, password, firstName, lastName, commandes, photos);
    }

}
