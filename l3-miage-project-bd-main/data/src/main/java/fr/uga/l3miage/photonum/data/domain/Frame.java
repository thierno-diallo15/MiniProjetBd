package fr.uga.l3miage.photonum.data.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Frame")
@DiscriminatorValue("F")
public class Frame extends Impression {

    @OneToMany(mappedBy = "frame")
    private List<Photo> photoFrames;

    @Column(name = "layout")
    private String layout;

    public Frame(Double price, Client person, Article article, Catalog formatQuality, List<Photo> photoFrames,
            String layout) {
        super(price, person, article, formatQuality);
        this.photoFrames = photoFrames;
        this.layout = layout;
    }

    public Frame(){
    }

    public List<Photo> getPhotoFrames() {
        return photoFrames;
    }

    public void setPhotoFrames(List<Photo> photoFrames) {
        this.photoFrames = photoFrames;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    

    // todo generate getters and setters after the mapping

}
