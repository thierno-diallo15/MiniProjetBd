package fr.uga.l3miage.photonum.domain.DTO;

public class ImageDTO {
    private Long id;
    private String description;
    private Boolean is_shared;
    private String path;
    private String resolution;
    private String setting;
    private String view_info;
    private Long frame_id;
    private Long owner_id;
    private Long page_id;
    private Long print_id;

    public ImageDTO() {
    }

    public ImageDTO(Long id, String description, Boolean is_shared, String path, String resolution, String setting,
            String view_info, Long frame_id, Long owner_id, Long page_id, Long print_id) {
        this.id = id;
        this.description = description;
        this.is_shared = is_shared;
        this.path = path;
        this.resolution = resolution;
        this.setting = setting;
        this.view_info = view_info;
        this.frame_id = frame_id;
        this.owner_id = owner_id;
        this.page_id = page_id;
        this.print_id = print_id;
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

    public Boolean getIs_shared() {
        return is_shared;
    }

    public void setIs_shared(Boolean is_shared) {
        this.is_shared = is_shared;
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

    public String getView_info() {
        return view_info;
    }

    public void setView_info(String view_info) {
        this.view_info = view_info;
    }

    public Long getFrame_id() {
        return frame_id;
    }

    public void setFrame_id(Long frame_id) {
        this.frame_id = frame_id;
    }

    public Long getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Long owner_id) {
        this.owner_id = owner_id;
    }

    public Long getPage_id() {
        return page_id;
    }

    public void setPage_id(Long page_id) {
        this.page_id = page_id;
    }

    public Long getPrint_id() {
        return print_id;
    }

    public void setPrint_id(Long print_id) {
        this.print_id = print_id;
    }

}
