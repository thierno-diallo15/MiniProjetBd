package fr.uga.l3miage.photonum.data.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Image {
    @Id
    @GeneratedValue
    private Long id;
    private String path;
    //todo à completer lors du mapping 
    private Client owner;
    private Double resolution;
    private Boolean isShared;

    //todo getters and setters after mapping 
}
