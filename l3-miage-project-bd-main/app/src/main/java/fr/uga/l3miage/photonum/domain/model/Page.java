package fr.uga.l3miage.photonum.domain.model;

import java.util.List;
import java.util.Objects;

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

    @ManyToOne
    private Calendar calendar;

    @ManyToOne
    private Album album;

    @OneToMany
    private List<Image> photoPages;

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
    public boolean equals(Object o){
        if(o == null) return false;
        if(!(o instanceof Page page )) return false;
        return  Objects.equals(layout, page.layout)
            && Objects.equals(calendar, page.calendar)
            && Objects.equals(album, page.album)
            && Objects.equals(photoPages, page.photoPages);
    }
    public int hashCode(){
        return Objects.hash(layout, calendar, album, photoPages);
    }
}
