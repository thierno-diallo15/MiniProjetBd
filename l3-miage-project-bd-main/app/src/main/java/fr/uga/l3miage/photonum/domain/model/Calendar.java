package fr.uga.l3miage.photonum.domain.model;

import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

    @OneToMany
    private Page[] pages = new Page[12];

    public Date getyear() {
        return year;
    }
    public void setyear(Date year) {
        this.year = year;
    }
    public Page[] getPages() {
        return pages;
    }
    public void setPages(Page[] pages) {
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
