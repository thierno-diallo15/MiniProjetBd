package fr.uga.l3miage.photonum.domain.model;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column( nullable = false)
    @NotBlank (message = "email is requierd ")
   @Email(message = "email not valid")
    private String email;

    @Column( nullable = false)
    @NotBlank(message = "password is requierd")
    private String password;

    @Column( nullable = false)
    @NotBlank(message = "firstName is requierd")
    private String firstName;

    @Column
    @NotBlank(message = "lastName is requierd")
    private String lastName;

    public Long getId() {
        return id;
    }
    public void setId(Long id){
        this.id = id;
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
