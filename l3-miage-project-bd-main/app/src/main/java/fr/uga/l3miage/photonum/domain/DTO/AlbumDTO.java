package fr.uga.l3miage.photonum.domain.DTO;

public class AlbumDTO {
    private String title;
    private Long id;

    public AlbumDTO() {
    }

    public AlbumDTO(String title, Long id) {
        this.title = title;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
