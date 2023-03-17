package fr.uga.l3miage.photonum.data.domain;

import java.util.List;
import java.util.Set;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Client")
public class Client {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "firsName", nullable = false)
    private String firstName;

    @Column
    private String lastName;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "client")
    private List<Address> addresses;

    @OneToMany(mappedBy = "person")
    private List<Impression> impressions;

    @OneToMany(mappedBy = "owner")
    private List<Photo> photos;

    @OneToMany(mappedBy = "client")
    private List<Order> commands;

    public Client(Long id, String email, String firstName, String lastName, String password, List<Address> addresses) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.addresses = addresses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddress(List<Address> addresses) {
        this.addresses = addresses;
    }
}
