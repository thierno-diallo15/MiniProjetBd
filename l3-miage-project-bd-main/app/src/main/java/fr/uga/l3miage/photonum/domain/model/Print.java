package fr.uga.l3miage.photonum.domain.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;

@Entity
public class Print extends Impression {

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Image> photos;

    public List<Image> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Image> photos) {
        this.photos = photos;
    }

}
