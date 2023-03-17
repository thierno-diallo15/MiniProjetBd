package fr.uga.l3miage.photonum.data.domain;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="Calendar")
@DiscriminatorValue("C")
public class Calendar extends Impression {
    //todo the mapping 
    @Column(name = "year",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date year;

    @OneToMany(mappedBy = "calendar")
    private Page[] pages = new Page[12];

    public Calendar(Double price, Client person, Article article, Catalog formatQuality, Date year, Page[] pages) {
        super(price, person, article, formatQuality);
        this.year = year;
        this.pages = pages;
    }

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


    }
