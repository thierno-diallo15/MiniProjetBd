package fr.uga.l3miage.photonum.data.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Page")
public class Page {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="layout", nullable = false)
    private String layout;

    @OneToMany(mappedBy = "page")
    private List<Image> photoPages;

    @ManyToOne
    private Calendar calendar;

    @ManyToOne
    private Album album;

    public Page(String layout, List<Image> photoPages, Calendar calendar, Album album) {
        this.layout = layout;
        this.photoPages = photoPages;
        this.calendar = calendar;
        this.album = album;
    }

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

    public List<Image> getPhotoPages() {
        return photoPages;
    }

    public void setPhotoPages(List<Image> photoPages) {
        this.photoPages = photoPages;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }


}
