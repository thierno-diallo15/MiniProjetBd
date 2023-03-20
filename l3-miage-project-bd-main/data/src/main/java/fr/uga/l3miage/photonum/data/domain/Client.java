package fr.uga.l3miage.photonum.data.domain;
import java.util.List;
import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

    @ManyToMany
    private Set<Address> addresses;

    //@OneToMany
    //private List<Image> photos;

    

    public Client(String email, String password, String firstName, String lastName, Set<Address> addresses) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addresses = addresses;
    }

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

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

}
