package fr.uga.l3miage.photonum.data.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Article {
    
    @Id
    @GeneratedValue
    private Long id;
    // Todo the mapping
    private int quantity;
    private Double price;
    // Todo generate getters and setters afters the mapping 
}
