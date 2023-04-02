package fr.uga.l3miage.photonum.domain.model;

import java.sql.Date;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Calendar")
public class Calendar extends Impression {

    @Column(name = "annee", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date year;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Page> pages;

    public Date getyear() {
        return year;
    }
    public void setyear(Date year) {
        this.year = year;
    }
    public Set<Page> getPages() {
        return pages;
    }
    public void setPages(Set<Page> pages) {
        this.pages = pages;
    }

    public boolean equals(Object o){
        if(this == o ) return true;
        if(!(o instanceof Calendar calendar) ) return false;
        if(!super.equals(o)) return false;
        return Objects.equals(year, calendar.year)
              && Objects.equals(pages, calendar.pages);
    }

    public int hashCode(){
        return Objects.hash(year,pages);
    }
}
