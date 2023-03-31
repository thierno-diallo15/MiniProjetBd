package fr.uga.l3miage.photonum.services;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uga.l3miage.photonum.domain.DTO.CommandeDTO;
import fr.uga.l3miage.photonum.domain.mapper.CommandeMapper;
import fr.uga.l3miage.photonum.domain.model.Client;
import fr.uga.l3miage.photonum.domain.model.Commande;
import fr.uga.l3miage.photonum.repository.ClientRepository;
import fr.uga.l3miage.photonum.repository.CommandeRepository;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;
    private CommandeMapper commandeMapper = Mappers.getMapper(CommandeMapper.class);
    
    @Autowired
    private ClientRepository clientRepository;
      //to do: remplacer clientId par ClientDTO pour meilleure affichage
      public List<CommandeDTO> getAll(){
        List<CommandeDTO> commandesDTO = new ArrayList<>();
        List<Commande> commandes = commandeRepository.findAll();
        CommandeDTO commandeDTO = new CommandeDTO();

        for (Commande cmd : commandes){
            commandeDTO = commandeMapper.entityToDTO(cmd);
            commandeDTO.setClientId(cmd.getClient().getId());
            commandesDTO.add(commandeDTO);
        }
        return commandesDTO;
    }

    public CommandeDTO getById(Long id){
        Commande commande = commandeRepository.get(id);
        CommandeDTO commandeDTO = commandeMapper.entityToDTO(commande);
        commandeDTO.setClientId(commande.getClient().getId());
        return (commandeDTO);
    }

    public CommandeDTO save(CommandeDTO commandeDTO){
        //convertir l'objet DTO -> l'objet Adresse
        Commande commande = commandeMapper.DTOToEntity(commandeDTO);
        Client client = clientRepository.get(commandeDTO.getClientId());
        //Mappeur non capable de convertir (Long) client_id -> l'objet Client
        //  -> on le fait manuellement 
        commande.setClient(client);

        Commande saved = commandeRepository.save(commande);
        CommandeDTO savedDTO = commandeMapper.entityToDTO(saved);
        //convertir manuellement l'objet Client -> (Long) client_id pour DTO
        savedDTO.setClientId(saved.getClient().getId());
        return  savedDTO;
    }

    public CommandeDTO update(CommandeDTO commandeDTO){
        //convertir l'objet DTO -> l'objet Adresse
        Commande commande = commandeMapper.DTOToEntity(commandeDTO);
        Client client = clientRepository.get(commandeDTO.getClientId());
        //Mappeur non capable de convertir (Long) client_id -> l'objet Client
        //  -> on le fait manuellement 
        commande.setClient(client);

        Commande saved = commandeRepository.update(commande);
        CommandeDTO savedDTO = commandeMapper.entityToDTO(saved);
        //convertir manuellement l'objet Client -> (Long) client_id pour DTO
        savedDTO.setClientId(saved.getClient().getId());
        return  savedDTO;
   } 

    
}
