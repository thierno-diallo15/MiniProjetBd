package fr.uga.l3miage.photonum.domain.DTO;

import java.util.List;

public class PageDTO {

    private Long id;
    private String layout;
    private List<Long> photoIds;

    public PageDTO(Long id, String layout, List<Long> photoIds) {
        this.id = id;
        this.layout = layout;
        this.photoIds = photoIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public List<Long> getPhotoIds() {
        return photoIds;
    }

    public void setPhotoIds(List<Long> photoIds) {
        this.photoIds = photoIds;
    }
}
