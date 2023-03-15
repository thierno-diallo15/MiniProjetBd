package fr.uga.l3miage.photonum.data.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Page {
    @Id
    @GeneratedValue
    private Long id;
    //todo the mapping 
    private Photo photo;
    private String layout;

    //todo generate getters and setters after the mapping
}
