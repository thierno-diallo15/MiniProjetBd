package fr.uga.l3miage.photonum.data.domain;

import java.util.Objects;

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

    public String getSetting() {
        return setting;
    }

    public void setSetting(String setting) {
        this.setting = setting;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    public Print getPrint() {
        return print;
    }

    public void setPrint(Print print) {
        this.print = print;
    }
    public boolean equals(Object o){
        if(o == null) return false;
        if(!(o instanceof Image image)) return false;
        return Objects.equals(path, image.path)
            && Objects.equals(resolution, image.resolution)
            && Objects.equals(isShared, image.isShared)
            && Objects.equals(setting, image.setting)
            && Objects.equals(description, image.description)
            && Objects.equals(owner, image.owner)
            && Objects.equals(page, image.page)
            && Objects.equals(frame, image.frame)
            && Objects.equals(print, image.print);
    }

public int hashCode(){
    return Objects.hash(path, resolution, isShared, setting, description, owner, page, frame, print);
}



}
