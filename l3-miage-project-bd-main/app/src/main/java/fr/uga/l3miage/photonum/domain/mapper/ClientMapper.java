package fr.uga.l3miage.photonum.domain.mapper;

import java.util.Collection;

import org.mapstruct.Mapper;

import fr.uga.l3miage.photonum.domain.DTO.ClientDTO;
import fr.uga.l3miage.photonum.domain.model.Client;

@Mapper
public interface ClientMapper {
    ClientDTO entityToDTO(Client client);

    Collection<ClientDTO> entityToDTO(Iterable<Client> clients);
}
