package fr.uga.l3miage.photonum.data.domain;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Album")
@DiscriminatorValue("A")
public class Album extends Impression {

    @Column(name = "coverPhoto")
    private Photo coverPhoto;

    @Column(name = "title", nullable = false)
    private String title;

    @OneToMany(mappedBy = "album")
    private Set<Page> pageAlbums;

    public Album(Double price, Client person, Article article, Catalog formatQuality, Photo coverPhoto, String title,
            Set<Page> pageAlbums) {
        super(price, person, article, formatQuality);
        this.coverPhoto = coverPhoto;
        this.title = title;
        this.pageAlbums = pageAlbums;
    }

    public Photo getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(Photo coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Page> getPageAlbums() {
        return pageAlbums;
    }

    public void setPageAlbums(Set<Page> pageAlbums) {
        this.pageAlbums = pageAlbums;
    }

    // TODO generete getters and setters after the mapping
}
