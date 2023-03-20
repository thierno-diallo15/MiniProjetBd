package fr.uga.l3miage.photonum.data.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
public class Frame extends Impression {

    @OneToMany(mappedBy = "frame")
    private List<Image> photoFrames;

    @Column(name = "layout")
    private String layout;

    public Frame(Double price, Client person, Article article, List<Image> photoFrames,
            String layout) {
        super(price, person, article);
        this.photoFrames = photoFrames;
        this.layout = layout;
    }

    public Frame(){
    }

    public List<Image> getPhotoFrames() {
        return photoFrames;
    }

    public void setPhotoFrames(List<Image> photoFrames) {
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
