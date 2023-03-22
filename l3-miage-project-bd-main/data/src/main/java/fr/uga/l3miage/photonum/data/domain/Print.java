package fr.uga.l3miage.photonum.data.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
@Entity
public class Print extends Impression {


@OneToMany(mappedBy = "print")
private List<Image> photoPrints;
    
}
