package fr.uga.l3miage.photonum.data.domain;

import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Print")
@DiscriminatorValue("Print")
public class Print extends Impression {

    @OneToMany(mappedBy = "print")
    private List<Photo> photoPrints;

    public Print(Double price, Client person, Article article, Catalog formatQuality, List<Photo> photoPrints) {
        super(price, person, article, formatQuality);
        this.photoPrints = photoPrints;
    }

    public List<Photo> getPhotoPrints() {
        return photoPrints;
    }

    public void setPhotoPrints(List<Photo> photoPrints) {
        this.photoPrints = photoPrints;
    }

    



    
}
