package fr.uga.l3miage.photonum.domain.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Album extends Impression {

    @Column(nullable = false)
    @NotBlank(message = "title is requierd")
    private String title;

    @OneToOne(fetch = FetchType.EAGER)
    @NotBlank( message = " cover is requierd ")
    private Image cover;

    @OneToMany(fetch = FetchType.EAGER)
    @NotBlank( message = " page is requierd ")
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
