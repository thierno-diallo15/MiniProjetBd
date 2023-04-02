package fr.uga.l3miage.photonum.domain.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Frame")
public class Frame extends Impression {

    @Column(name = "layout")
    private String layout;
    
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Image> photos;

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }
    public List<Image> getPhotos() {
        return photos;
    }
    public void setPhotos(List<Image> photos) {
        this.photos = photos;
    }
    
}
