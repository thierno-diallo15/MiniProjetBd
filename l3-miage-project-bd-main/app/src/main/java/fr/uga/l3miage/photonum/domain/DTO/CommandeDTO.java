package fr.uga.l3miage.photonum.domain.DTO;

import java.sql.Date;

import fr.uga.l3miage.photonum.domain.model.Client;

public class CommandeDTO {

    private Long id;
    private Date date;
    private Double totalPrice;
    private Long clientId;
    
    public CommandeDTO() {
    }
    public CommandeDTO(Long id, Date date, Double totalPrice, Long clientId) {
        this.id = id;
        this.date = date;
        this.totalPrice = totalPrice;
        this.clientId = clientId;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public Long getClientId() {
        return clientId;
    }
    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    
}
