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
    private Long id;

    @Column
    private String path;
    @Column
    private String viewInfo ;

    @Column
    private String resolution;

    @Column
    private Boolean isShared;

    @Column
    private String settings;

    @Column
    private String description;

    @ManyToOne
    private Frame frame;

    @ManyToOne
    private Page page;

    @ManyToOne
    private Print print;

    @ManyToOne
    private Client owner;

    /*public Image() {
    }*/

    /*public Image(String path, String viewInfo, String resolution, Boolean isShared, String settings, String description,
            Frame frame, Page page, Print print, Client owner) {
        this.path = path;
        this.viewInfo = viewInfo;
        this.resolution = resolution;
        this.isShared = isShared;
        this.settings = settings;
        this.description = description;
        this.frame = frame;
        this.page = page;
        this.print = print;
        this.owner = owner;
    }*/

    public Long getId() {
        return id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getViewInfo() {
        return viewInfo;
    }

    public void setViewInfo(String viewInfo) {
        this.viewInfo = viewInfo;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public Boolean getIsShared() {
        return isShared;
    }

    public void setIsShared(Boolean isShared) {
        this.isShared = isShared;
    }

    public String getSettings() {
        return settings;
    }

    public void setSettings(String settings) {
        this.settings = settings;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Print getPrint() {
        return print;
    }

    public void setPrint(Print print) {
        this.print = print;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }
    
    

    //todo getters and setters after mapping 


}
