package fr.uga.l3miage.photonum.services;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uga.l3miage.photonum.domain.DTO.ClientDTO;
import fr.uga.l3miage.photonum.domain.mapper.ClientMapper;
import fr.uga.l3miage.photonum.domain.model.Client;
import fr.uga.l3miage.photonum.repository.ClientRepository;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    private ClientMapper clientMapper = Mappers.getMapper(ClientMapper.class);

    public ClientDTO getById(Long id){
        Client client = clientRepository.get(id);
        return clientMapper.entityToDTO(client) ;
    }

    public List<ClientDTO> getAll(){
        List<Client> clients = clientRepository.findAll();
        return new ArrayList<>(clientMapper.entityToDTO(clients));
    }

    public ClientDTO save(Client nClient){
        Client saved = clientRepository.save(nClient);
        return  clientMapper.entityToDTO(saved);
    }

    public ClientDTO update(Client client){
        Client updated = clientRepository.update(client);
        return clientMapper.entityToDTO(updated);
    }
}
