package fr.uga.l3miage.photonum.domain.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Album extends Impression {

    @Column(nullable = false)
    private String title;

    @OneToOne(fetch = FetchType.EAGER)
    private Image cover;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Page> pages;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Image getCover() {
        return cover;
    }
    public void setCover(Image cover) {
        this.cover = cover;
    }
    public Set<Page> getPages() {
        return pages;
    }
    public void setPages(Set<Page> pages) {
        this.pages = pages;
    }

}
