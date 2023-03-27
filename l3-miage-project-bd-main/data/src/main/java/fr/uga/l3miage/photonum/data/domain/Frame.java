package fr.uga.l3miage.photonum.data.domain;

import java.util.List;
import java.util.Objects;

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
    public List<Image> getPhotoFrames() {
        return photoFrames;
    }
    public void setPhotoFrames(List<Image> photoFrames) {
        this.photoFrames = photoFrames;
    }
    public boolean equals(Object o){
        if(o == null) return false;
        if(!(o instanceof Frame frame)) return false;
        if(!super.equals(o)) return false;
        return Objects.equals(layout, frame.layout)
            && Objects.equals(photoFrames, frame.photoFrames);
    }
    public int hashCode(){
        return Objects.hash(layout, photoFrames);
    }
    

}
