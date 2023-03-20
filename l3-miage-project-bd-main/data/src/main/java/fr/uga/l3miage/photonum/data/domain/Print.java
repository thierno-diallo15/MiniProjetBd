package fr.uga.l3miage.photonum.data.domain;

import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
public class Print extends Impression {

    @OneToMany
    private List<Image> photoPrints;

    public Print(Double price, Client person, Article article, List<Image> photoPrints) {
        super(price, person, article);
        this.photoPrints = photoPrints;
    }

    public List<Image> getPhotoPrints() {
        return photoPrints;
    }

    public void setPhotoPrints(List<Image> photoPrints) {
        this.photoPrints = photoPrints;
    }

    



    
}
