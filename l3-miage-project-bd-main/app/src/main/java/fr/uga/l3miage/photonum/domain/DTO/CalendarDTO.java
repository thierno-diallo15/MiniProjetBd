package fr.uga.l3miage.photonum.domain.DTO;

import java.sql.Date;

public class CalendarDTO {
    private Date annee;
    private Long id;

    public CalendarDTO() {
    }

    public CalendarDTO(Date annee, Long id) {
        this.annee = annee;
        this.id = id;
    }

    public Date getAnnee() {
        return annee;
    }

    public void setAnnee(Date annee) {
        this.annee = annee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
