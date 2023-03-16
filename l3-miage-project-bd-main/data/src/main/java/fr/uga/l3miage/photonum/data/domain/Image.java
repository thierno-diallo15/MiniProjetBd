package fr.uga.l3miage.photonum.data.domain;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="type_image", discriminatorType = DiscriminatorType.STRING)
@Table(name= "Image")
public class Image {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="path_image",nullable = false)
    private String path;
    //todo à completer lors du mapping 
    @Column(name ="viewInfo", nullable = false)
    private String viewInfo ;

    @Column(name="resolution")
    private String resolution;

    @Column(name="isShared")
    private Boolean isShared;

    public Image(String path, String viewInfo, String resolution, Boolean isShared) {
        this.path = path;
        this.viewInfo = viewInfo;
        this.resolution = resolution;
        this.isShared = isShared;
    }

    public Image() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    //todo getters and setters after mapping 


}
