package fr.uga.l3miage.photonum.domain.mapper;

import java.util.Collection;

import org.mapstruct.Mapper;

import fr.uga.l3miage.photonum.domain.DTO.CommandeDTO;
import fr.uga.l3miage.photonum.domain.model.Commande;

@Mapper
public interface CommandeMapper {
    CommandeDTO entityToDTO(Commande commande);
    Commande DTOToEntity(CommandeDTO commandeDto);

    Collection<CommandeDTO> entityToDTO(Iterable<Commande> commandes);
    Collection<Commande> DTOToEntity(Iterable<CommandeDTO> commandesDTO);
}
