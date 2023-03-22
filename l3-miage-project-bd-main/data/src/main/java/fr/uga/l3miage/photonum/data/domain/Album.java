package fr.uga.l3miage.photonum.data.domain;

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
    private Set<Page> pageAlbums;

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
