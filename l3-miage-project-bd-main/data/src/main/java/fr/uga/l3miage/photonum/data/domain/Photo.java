package fr.uga.l3miage.photonum.data.domain;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Photo")
@DiscriminatorValue("P")
public class Photo extends Image {

    // todo the mapping
    @Column(name = "settings")
    private String settings;

    @Column(name = "description")
    private String description;

    @ManyToOne
    private Frame frame;

    @ManyToOne
    private Page page;

    @ManyToOne
    private Print print;

    @ManyToOne
    private Client owner;
     
    public Photo(String path, String viewInfo, String resolution, Boolean isShared) {
        super(path, viewInfo, resolution, isShared);
    }

    public Photo() {
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

}
