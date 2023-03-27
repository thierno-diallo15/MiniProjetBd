package fr.uga.l3miage.photonum.data.domain;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
@Entity
public class Print extends Impression {


    @OneToMany(mappedBy = "print")
    private List<Image> photoPrints;

    public List<Image> getPhotoPrints() {
        return photoPrints;
    }

    public void setPhotoPrints(List<Image> photoPrints) {
        this.photoPrints = photoPrints;
    }
    
    public boolean equals(Object o){
        if(o ==  null) return false;
        if(!(o instanceof Print print)) return false;
        if(!super.equals(o)) return false;
        return Objects.equals(photoPrints, print.photoPrints);
    }
    public int hashCode(){
        return Objects.hash(photoPrints);
    }
}
