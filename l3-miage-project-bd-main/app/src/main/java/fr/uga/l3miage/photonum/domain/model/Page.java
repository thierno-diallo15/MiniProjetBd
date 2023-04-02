package fr.uga.l3miage.photonum.domain.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Page")
public class Page {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="layout", nullable = false)
    private String layout;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Image> photos;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
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

    public boolean equals(Object o){
        if(o == null) return false;
        if(!(o instanceof Page page )) return false;
        return  Objects.equals(layout, page.layout)
            // && Objects.equals(calendar, page.calendar)
            // && Objects.equals(album, page.album)
            && Objects.equals(photos, page.photos);
    }
    public int hashCode(){
        return Objects.hash(layout, photos);
    }
    
}
