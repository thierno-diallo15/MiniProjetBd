package fr.uga.l3miage.photonum.data.domain;

import java.util.List;

import jakarta.persistence.Entity;

@Entity
public class Frame extends Impression {
    
    //todo The mapping

    private List<Photo> photos;
    private String layout;

    //todo generate getters and setters after the mapping

}
