package fr.uga.l3miage.photonum.domain.DTO;

import fr.uga.l3miage.photonum.domain.model.Catalog;

public class ArticleDTO {

    private Long id;
    private Catalog formatQuality;
    private int quantity;
    private Double price;
    private Long commandeId;
    
    public ArticleDTO(Long id, Catalog formatQuality, int quantity, Double price, Long commandeId) {
        this.id = id;
        this.formatQuality = formatQuality;
        this.quantity = quantity;
        this.price = price;
        this.commandeId = commandeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Catalog getFormatQuality() {
        return formatQuality;
    }

    public void setFormatQuality(Catalog formatQuality) {
        this.formatQuality = formatQuality;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getCommandeId() {
        return commandeId;
    }

    public void setCommandeId(Long commandeId) {
        this.commandeId = commandeId;
    }

    
}
