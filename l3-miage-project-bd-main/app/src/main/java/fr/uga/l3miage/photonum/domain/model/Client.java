package fr.uga.l3miage.photonum.domain.model;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column( nullable = false)
    private String email;

    @Column( nullable = false)
    private String password;

    @Column( nullable = false)
    private String firstName;

    @Column
    private String lastName;

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
            && Objects.equals(lastName, client.lastName) ;
    }
    public int hashCode(){
        return Objects.hash(email, password, firstName, lastName);
    }

}
