package fr.uga.l3miage.photonum.data.domain;

import java.util.List;

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

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "firsName", nullable = false)
    private String firstName;

    @Column
    private String lastName;

    @Column(name = "password" ,nullable= false)
    private String  password;

    @Column
    private List<String> address;


    @OneToMany
    private List<Impression> impressions ;

    @OneToMany
    private List<Photo> photos;

    @OneToMany
    private List<Command> commandes;

    public Client(Long id, String email, String firstName, String lastName, String password, List<String> address) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.address = address;
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

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }
}
