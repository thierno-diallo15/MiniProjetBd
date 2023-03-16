package fr.uga.l3miage.photonum.data.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.resource.beans.internal.FallbackBeanInstanceProducer;

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
    @Column(name = "annee",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date annee;

    @OneToMany(mappedBy = "calendar")
    private Page[] pages = new Page[12];

    public Calendar(Double price, Client person, Article article, Catalog formatQuality, Date annee, Page[] pages) {
        super(price, person, article, formatQuality);
        this.annee = annee;
        this.pages = pages;
    }

    public Date getAnnee() {
        return annee;
    }

    public void setAnnee(Date annee) {
        this.annee = annee;
    }



    public Page[] getPages() {
        return pages;
    }



    public void setPages(Page[] pages) {
        this.pages = pages;
    }


    }
