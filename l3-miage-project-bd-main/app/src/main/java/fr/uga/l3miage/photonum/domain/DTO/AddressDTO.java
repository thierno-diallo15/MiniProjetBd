package fr.uga.l3miage.photonum.domain.DTO;

public class AddressDTO {
    private Long id;
    private String description;
    private Long clientId;

    public AddressDTO(){};

    public AddressDTO(Long id, String description, Long clientId) {
        this.id = id;
        this.description = description;
        this.clientId = clientId;
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

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

}
