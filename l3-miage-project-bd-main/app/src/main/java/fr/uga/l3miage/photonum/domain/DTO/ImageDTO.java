package fr.uga.l3miage.photonum.domain.DTO;

public class ImageDTO {
    private Long id;
    private String description;
    private Boolean isShared;
    private String path;
    private String resolution;
    private String setting;
    private String viewInfo;
    private Long ownerId;

    public ImageDTO() {
    }

    public ImageDTO(String description, Boolean isShared, String path, String resolution, String setting,
            String viewInfo, Long ownerId) {
        this.description = description;
        this.isShared = isShared;
        this.path = path;
        this.resolution = resolution;
        this.setting = setting;
        this.viewInfo = viewInfo;
        this.ownerId = ownerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsShared() {
        return isShared;
    }

    public void setIsShared(Boolean isShared) {
        this.isShared = isShared;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getSetting() {
        return setting;
    }

    public void setSetting(String setting) {
        this.setting = setting;
    }

    public String getViewInfo() {
        return viewInfo;
    }

    public void setViewInfo(String viewInfo) {
        this.viewInfo = viewInfo;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

}
