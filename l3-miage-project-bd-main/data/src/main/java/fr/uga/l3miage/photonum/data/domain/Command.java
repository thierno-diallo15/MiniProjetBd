package fr.uga.l3miage.photonum.data.domain;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Command {
    @Id
    @GeneratedValue
    private Long id;
    private Date date;
    // todo the mapping 
    private Double totalPrice;
    private String deliveryAddress;

// todo generate getters and setters after mapping 
}
