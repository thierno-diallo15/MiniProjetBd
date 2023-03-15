package fr.uga.l3miage.photonum.data.domain;

import jakarta.persistence.Entity;

@Entity
public class Photo extends Image {

    // todo the mapping 
    private String retouchingParams;
    private String description;

   // getters and setters after the mapping 
}
