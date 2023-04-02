package fr.uga.l3miage.photonum.domain.DTO;

import java.util.List;

public class PrintDTO {
    private Long id;
    private Double price;
    private Long clientId;
    private Long articleId;
    private List<Long> photoIds;
    
    public PrintDTO(Long id, Double price, Long clientId, Long articleId, List<Long> photoIds) {
        this.id = id;
        this.price = price;
        this.clientId = clientId;
        this.articleId = articleId;
        this.photoIds = photoIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public List<Long> getPhotoIds() {
        return photoIds;
    }

    public void setPhotoIds(List<Long> photoIds) {
        this.photoIds = photoIds;
    }

    
}
