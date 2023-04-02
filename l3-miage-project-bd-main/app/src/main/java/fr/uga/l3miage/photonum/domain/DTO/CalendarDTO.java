package fr.uga.l3miage.photonum.domain.DTO;

import java.sql.Date;
import java.util.Set;

public class CalendarDTO {
    
    private Long id;
    private Date annee;
    private Double price;
    private Long clientId;
    private Long articleId;
    private Set<Long> pageIds;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getAnnee() {
        return annee;
    }
    public void setAnnee(Date annee) {
        this.annee = annee;
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
    public Set<Long> getPageIds() {
        return pageIds;
    }
    public void setPageIds(Set<Long> pageIds) {
        this.pageIds = pageIds;
    }

    

}
