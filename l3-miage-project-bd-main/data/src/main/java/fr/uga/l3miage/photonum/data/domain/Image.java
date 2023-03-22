package fr.uga.l3miage.photonum.data.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Image {

   @Id
    @GeneratedValue
    private Long Id;

    @Column
    private String path;

    @Column
    private String viewInfo;

    @Column
    private String resolution;

    @Column
    private Boolean isShared;

    @Column
    private String setting;

    @Column
    private String description;

    @ManyToOne
    private Client owner;

    @ManyToOne
    private Page page;

    @ManyToOne
    private Frame frame;

    @ManyToOne
    private Print print;






}
