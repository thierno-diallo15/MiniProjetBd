package fr.uga.l3miage.photonum.data.domain;

import java.util.Set;

import jakarta.persistence.Entity;

@Entity
public class Album extends Impression {
    
    // TODO the mapping 
    private Photo coverPhoto;
    private String title;
    private Set<Page> pages;

    // TODO generete getters and setters after the mapping 
}
