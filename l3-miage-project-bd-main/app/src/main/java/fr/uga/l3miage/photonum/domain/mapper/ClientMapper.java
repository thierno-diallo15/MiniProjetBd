package fr.uga.l3miage.photonum.domain.mapper;

import java.util.Collection;

import org.mapstruct.Mapper;

import fr.uga.l3miage.photonum.domain.DTO.ClientDTO;
import fr.uga.l3miage.photonum.domain.model.Client;

@Mapper
public interface ClientMapper {
    ClientDTO entityToDTO(Client client);
    Client DTOToEntity(ClientDTO clientDTO);

    Collection<ClientDTO> entityToDTO(Iterable<Client> clients);
    Collection<Client> DTOToEntity(Iterable<ClientDTO> clientsDTO);
}
