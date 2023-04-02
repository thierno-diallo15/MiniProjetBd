package fr.uga.l3miage.photonum.domain.model;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Album")
public class Album extends Impression {

    @Column(name = "title", nullable = false)
    private String title;

    @OneToMany
    private Set<Page> pages;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Set<Page> getPageAlbums() {
        return pages;
    }
    public void setPageAlbums(Set<Page> pages) {
        this.pages = pages;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Album album)) return false;
        if(!super.equals(o)) return false;
       return  Objects.equals(title, album.title)
            && Objects.equals(pages, album.pages);
    }

    @Override
    public int hashCode(){
        return Objects.hash(title,pages);
    }
    

    
    
}
