package fr.uga.l3miage.photonum.data.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Frame")
public class Frame extends Impression {

    @Column(name = "layout")
    private String layout;
    
    @OneToMany(mappedBy = "frame")
    private List<Image> photoFrames;

    public String getLayout() {
        return layout;
    }
    public void setLayout(String layout) {
        this.layout = layout;
    }

}
