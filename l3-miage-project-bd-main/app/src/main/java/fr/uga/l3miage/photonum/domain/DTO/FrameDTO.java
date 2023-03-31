package fr.uga.l3miage.photonum.domain.DTO;

public class FrameDTO {
    private String layout;
    private Long id;

    public FrameDTO() {
    }

    public FrameDTO(String layout, Long id) {
        this.layout = layout;
        this.id = id;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
